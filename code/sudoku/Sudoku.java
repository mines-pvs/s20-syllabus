import java.io.*;
import java.util.*;
import com.microsoft.z3.*;

public class Sudoku {
    Puzzle puzzle;

    Context ctx;
    Solver smt;

    FuncDecl grid;

    public Sudoku(Puzzle p) {
        this.puzzle = p;

        // init Z3
        initZ3();

        grid = ctx.mkFuncDecl("Grid", new Sort[]{ctx.mkIntSort(),ctx.mkIntSort()}, ctx.mkIntSort());

        BoolExpr result = ctx.mkEq(ctx.mkApp(grid, ctx.mkInt(0), ctx.mkInt(0)), ctx.mkInt(9));
        smt.add(result);

        Status st = smt.check();
        if(st == Status.SATISFIABLE) {
            Model model = smt.getModel();

            IntExpr z = (IntExpr)ctx.mkApp(grid, ctx.mkInt(0), ctx.mkInt(0));
            int val = ((IntNum)model.evaluate(z, true)).getInt();
            System.out.printf("Value = %d\n", val);
        }

        System.out.println(p.toString());
    }

    public static void main(String[] argv) {
        if(argv.length == 0) {
            System.err.println("Must enter filename");
        } else {
            for(String f : argv) {
                try {
                    Puzzle p = Puzzle.loadPuzzle(f);
                    Sudoku s = new Sudoku(p);
                } catch(Exception ex) {
                    System.err.printf("Could not load puzzle: %s\n", f);
                }
            }
        }
    }

    void initZ3() {
        com.microsoft.z3.Global.ToggleWarningMessages(true);
        Log.open("sudoku.log");

        System.out.printf("Z3 Major Version: %s\n", Version.getMajor());
        System.out.printf("Z3 Minor Version: %s\n", Version.getMinor());

        HashMap<String, String> cfg = new HashMap<String, String>();
        cfg.put("model", "true");
        ctx = new Context(cfg);

        smt = ctx.mkSolver();
    }
}

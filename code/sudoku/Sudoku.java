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

        // add the fixed elements of the grid
        for(int i = 0; i < p.puzzle.length; i++) {
            int z = p.puzzle[i];
            int x = i % p.size;
            int y = i / p.size;
            if(z > 0) {
                BoolExpr result = ctx.mkEq(ctx.mkApp(grid, ctx.mkInt(x), ctx.mkInt(y)), ctx.mkInt(z));
                smt.add(result);
            }

            BoolExpr result1 = ctx.mkGe((ArithExpr)ctx.mkApp(grid, ctx.mkInt(x), ctx.mkInt(y)), ctx.mkInt(1));
            BoolExpr result2 = ctx.mkLe((ArithExpr)ctx.mkApp(grid, ctx.mkInt(x), ctx.mkInt(y)), ctx.mkInt(p.size));
            smt.add(ctx.mkAnd(result1,result2));
        }

        // add the row constraints
        for(int y = 0; y < p.size; y++) {
            Expr[] row = new Expr[p.size];
            for(int x = 0; x < p.size; x++) {
                row[x] = ctx.mkApp(grid, ctx.mkInt(x), ctx.mkInt(y));
            }
            BoolExpr result = ctx.mkDistinct(row);
            smt.add(result);
        }

        // add the column constraints
        for(int x = 0; x < p.size; x++) {
            Expr[] col = new Expr[p.size];
            for(int y = 0; y < p.size; y++) {
                col[y] = ctx.mkApp(grid, ctx.mkInt(x), ctx.mkInt(y));
            }
            BoolExpr result = ctx.mkDistinct(col);
            smt.add(result);
        }

        // add the box constraints
        for(int by = 0; by < p.inner; by++) {
            for(int bx = 0; bx < p.inner; bx++) {
                // iterate through the box
                Expr[] box = new Expr[p.size];
                for(int k = 0; k < p.size; k++) {
                    int x = bx*p.inner + (k % p.inner);
                    int y = by*p.inner + (k / p.inner);
                    box[k] = ctx.mkApp(grid, ctx.mkInt(x), ctx.mkInt(y));
                }
                BoolExpr result = ctx.mkDistinct(box);
                smt.add(result);
            }
        }

        Status st = smt.check();
        if(st == Status.SATISFIABLE) {
            Model model = smt.getModel();

            int temp[] = new int[p.puzzle.length];
            Puzzle pt = new Puzzle(temp, p.size, p.inner);
            int k = 0;
            for(int y = 0; y < p.size; y++) {
                for(int x = 0; x < p.size; x++) {
                    IntExpr z = (IntExpr)ctx.mkApp(grid, ctx.mkInt(x), ctx.mkInt(y));
                    int val = ((IntNum)model.evaluate(z, true)).getInt();
                    //System.out.printf("Value = %d\n", val);
                    temp[k] = val;
                    ++k;
                }
            }

            System.out.println(pt);
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

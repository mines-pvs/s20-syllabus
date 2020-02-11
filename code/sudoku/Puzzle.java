import java.io.*;
import java.util.*;

public class Puzzle {
    int puzzle[];
    int size;
    int inner;

    public Puzzle(int puzzle[], int size, int inner) {
        this.puzzle = puzzle;
        this.size = size;
        this.inner = inner;
    }

    public static Puzzle loadPuzzle(String filename) throws Exception {
        Vector<Integer> temp = new Vector<Integer>();

        FileInputStream f = new FileInputStream(filename);
        Scanner s = new Scanner(f);
        while(s.hasNext()) {
            if(s.hasNextInt()) {
                int x = s.nextInt();
                temp.add(x);
            } else {
                String y = s.next();
                temp.add(0); // "blank"
            }
        }
        f.close();

        int size = (int)Math.sqrt(temp.size());
        int inner = (int)Math.sqrt(size);
        int len = size*size;
        if(len != temp.size() || inner*inner != size) {
            throw new Exception("invalid puzzle dimensions");
        }

        int[] result = new int[len];
        for(int i = 0; i < len; i++) {
            result[i] = temp.get(i);
        }

        return new Puzzle(result, size, inner);
    }

    public String toString() {
        int digits = (""+size).length();

        int i = 0;
        String result = "";

        for(int y = 0; y <= size; y++) {
            if(y > 0) result += " |\n";
            if(y % inner == 0) {
                for(int x = 0; x < size; x++) {
                    if(x > 0) result += "-";
                    if(x % inner == 0) result += "+-";
                    for(int k = 0; k < digits; k++) {
                        result += "-";
                    }
                }
                result += "-+\n";
            }
            if(y == size) break;
            for(int x = 0; x < size; x++) {
                if(x > 0) result += " ";
                if(x % inner == 0) result += "| ";
                if(puzzle[i] > 0) {
                    result += String.format("%0"+digits+"d", puzzle[i]);
                } else {
                    for(int k = 0; k < digits; k++) {
                        result += ".";
                    }
                }
                ++i;
            }
        }

        return result;
    }
}

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Board board = new Board(20);
        Structures structures = new Structures();
        int[][] glider = structures.glider;
        int[][] frog = structures.frog;
        board.drawOnBoard(frog);

        int steps = 0;
        while (steps < 10) {
            board.evolve();
            steps++;
        }
    }
}

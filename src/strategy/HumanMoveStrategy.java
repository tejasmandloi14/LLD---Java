package strategy;

import java.util.Scanner;
import model.Board;

public class HumanMoveStrategy implements MoveStrategy {

    private final Scanner scanner;

    public HumanMoveStrategy(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int[] chooseMove(Board board) {

        System.out.print("Enter row and column: ");

        int row = scanner.nextInt();
        int col = scanner.nextInt();

        return new int[]{row, col};
    }
}
package strategy;

import model.Board;

public class CpuMoveStrategy implements MoveStrategy {

    @Override
    public int[] chooseMove(Board board) {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                if (board.isValidMove(row, col)) {
                    return new int[]{row, col};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
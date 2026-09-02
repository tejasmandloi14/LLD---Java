package strategy;

import model.Board;

public interface MoveStrategy {

    int[] chooseMove(Board board);
}
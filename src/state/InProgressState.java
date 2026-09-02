package state;

import game.Game;

public class InProgressState implements GameState {

    @Override
    public void playMove(Game game, int row, int col) {

        game.makeMove(row, col);
    }
}
package state;

import game.Game;

public interface GameState {

    void playMove(Game game, int row, int col);
}
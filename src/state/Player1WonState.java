package state;

import game.Game;

public class Player1WonState implements GameState {

    @Override
    public void playMove(Game game, int row, int col) {

        System.out.println("Game Over! Player 1 already won.");
    }
}
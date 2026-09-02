package state;

import game.Game;

public class Player2WonState implements GameState {

    @Override
    public void playMove(Game game, int row, int col) {

        System.out.println("Game Over! Player 2 already won.");
    }
}
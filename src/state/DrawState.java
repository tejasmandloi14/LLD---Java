package state;

import game.Game;

public class DrawState implements GameState {

    @Override
    public void playMove(Game game, int row, int col) {

        System.out.println("Game Over! It's a draw.");
    }
}
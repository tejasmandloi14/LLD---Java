package game;

import model.Board;
import model.Player;
import model.Symbol;

import state.DrawState;
import state.GameState;
import state.InProgressState;
import state.Player1WonState;
import state.Player2WonState;

public class Game {

    private final Board board;

    private final Player player1;
    private final Player player2;

    private Player currentPlayer;

    private GameState currentState;

    public Game(Player player1, Player player2) {

        this.board = new Board();

        this.player1 = player1;
        this.player2 = player2;

        this.currentPlayer = player1;

        this.currentState = new InProgressState();
    }

    // Called from Main
    public void playTurn() {

        int[] move = currentPlayer.chooseMove(board);

        playMove(move[0], move[1]);
    }

    // Entry point for making a move
    public void playMove(int row, int col) {

        currentState.playMove(this, row, col);
    }

    // Called by InProgressState
    public void makeMove(int row, int col) {

        // Actually make the move on the board
        board.makeMove(
                row,
                col,
                currentPlayer.getSymbol()
        );

        System.out.println(
                currentPlayer.getName()
                        + " played at "
                        + row + ", " + col
        );

        board.printBoard();

        // Check winner
        if (hasWon()) {

            if (currentPlayer == player1) {
                currentState = new Player1WonState();
            } else {
                currentState = new Player2WonState();
            }

            System.out.println(
                    currentPlayer.getName() + " won!"
            );

            return;
        }

        // Check draw
        if (board.isFull()) {

            currentState = new DrawState();

            System.out.println("Game Draw!");

            return;
        }

        // Continue game
        switchPlayer();
    }

    private void switchPlayer() {

        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWon() {

        Symbol symbol = currentPlayer.getSymbol();

        // Rows
        for (int row = 0; row < 3; row++) {

            if (board.getSymbol(row, 0) == symbol &&
                board.getSymbol(row, 1) == symbol &&
                board.getSymbol(row, 2) == symbol) {

                return true;
            }
        }

        // Columns
        for (int col = 0; col < 3; col++) {

            if (board.getSymbol(0, col) == symbol &&
                board.getSymbol(1, col) == symbol &&
                board.getSymbol(2, col) == symbol) {

                return true;
            }
        }

        // Main diagonal
        if (board.getSymbol(0, 0) == symbol &&
            board.getSymbol(1, 1) == symbol &&
            board.getSymbol(2, 2) == symbol) {

            return true;
        }

        // Other diagonal
        if (board.getSymbol(0, 2) == symbol &&
            board.getSymbol(1, 1) == symbol &&
            board.getSymbol(2, 0) == symbol) {

            return true;
        }

        return false;
    }
}

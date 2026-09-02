package model;

public class Board {

    private static final int SIZE = 3;

    private final Cell[][] cells;

    public Board() {

        cells = new Cell[SIZE][SIZE];

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    public boolean isValidMove(int row, int col) {

        if (row < 0 || row >= SIZE ||
            col < 0 || col >= SIZE) {

            return false;
        }

        return cells[row][col].isEmpty();
    }

    public void makeMove(int row, int col, Symbol symbol) {

        if (!isValidMove(row, col)) {
            throw new IllegalArgumentException(
                    "Invalid move: " + row + ", " + col
            );
        }

        cells[row][col].setSymbol(symbol);
    }

    public Symbol getSymbol(int row, int col) {
        return cells[row][col].getSymbol();
    }

    public boolean isFull() {

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {

                if (cells[row][col].isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    public void printBoard() {

        System.out.println();

        for (int row = 0; row < SIZE; row++) {

            for (int col = 0; col < SIZE; col++) {

                System.out.print(
                        cells[row][col].getSymbol() + " "
                );
            }

            System.out.println();
        }

        System.out.println();
    }
}
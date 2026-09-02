package model;

import strategy.MoveStrategy;

public class Player {

    private final String name;
    private final Symbol symbol;
    private final MoveStrategy moveStrategy;

    public Player(
            String name,
            Symbol symbol,
            MoveStrategy moveStrategy) {

        this.name = name;
        this.symbol = symbol;
        this.moveStrategy = moveStrategy;
    }

    public int[] chooseMove(Board board) {
        return moveStrategy.chooseMove(board);
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public MoveStrategy getMoveStrategy() {
        return moveStrategy;
    }
}
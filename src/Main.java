import java.util.Scanner;

import game.Game;
import model.Player;
import model.Symbol;

import strategy.CpuMoveStrategy;
import strategy.HumanMoveStrategy;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Player 1 = Human
        Player player1 = new Player(
                "Player 1",
                Symbol.X,
                new HumanMoveStrategy(scanner)
        );

        // Player 2 = CPU
        Player player2 = new Player(
                "Player 2",
                Symbol.O,
                new HumanMoveStrategy(scanner)
        );

        // Create game
        Game game = new Game(player1, player2);

        // Keep playing until game reaches
        // Won or Draw state
        while (true) {
            game.playTurn();
        }
    }
}

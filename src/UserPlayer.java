import java.util.Scanner;

public class UserPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for the UserPlayer class.
     *
     * @param playerSymbol The symbol ('X' or 'O') associated with the player.
     * @param game         A reference to the game in which the player participates.
     */
    public UserPlayer(char playerSymbol, Game game) {
        super(playerSymbol, game);
    }

    /**
     * Implementation of the run method for the UserPlayer.
     * This method defines the user-controlled player's behavior during the game.
     */
    @Override
    public void run() {
        while (true) {
            synchronized (game) {
                // Check if it's the current player's turn based on their symbol ('X' or 'O').
                if (game.getTurn() == (playerSymbol == 'X' ? Game.PlayerType.X : Game.PlayerType.O)) {
                    System.out.println("Your turn, enter row and column (0-4): ");
                    game.printBoard();
                    int row = scanner.nextInt();
                    int col = scanner.nextInt();

                    if (row >= 0 && row < 5 && col >= 0 && col < 5 && game.gameBoard[row][col] == ' ') {
                        // Update the game board with the user's move.
                        game.gameBoard[row][col] = playerSymbol;

                        // Check if the user's move results in a winning condition.
                        if (game.isWinningMove(row, col, playerSymbol)) {
                            System.out.println("Player " + playerSymbol + " wins!");
                            game.printBoard(); // Display the final game board.
                            break;
                        }
                        if(game.getFreeCells().length == 0)
                            break;


                        game.printBoard();
                        game.changeTurn(); // Switch the turn to the other player.

                    } else {
                        System.out.println("Invalid move. Try again.");
                    }
                }
            }
        }
    }
}

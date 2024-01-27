import java.util.Random;

public class SelfPlayer extends Player {
    private final Random random = new Random(); // Create an instance of Random here.

    /**
     * Constructor for the SelfPlayer class.
     *
     * @param playerSymbol The symbol ('X' or 'O') associated with the player.
     * @param game         A reference to the game in which the player participates.
     */
    public SelfPlayer(char playerSymbol, Game game) {
        super(playerSymbol, game);
    }

    /**
     * Implementation of the run method for the SelfPlayer.
     * This method defines the player's behavior during the game.
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500); // Pause the player's turn for 500 milliseconds.

                synchronized (game) {
                    // Check if it's the current player's turn based on their symbol ('X' or 'O').
                    if (game.getTurn() == (playerSymbol == 'X' ? Game.PlayerType.X : Game.PlayerType.O)) {
                        // Get the list of available (free) cells on the game board.
                        Cell[] freeCells = game.getFreeCells();

                        if (freeCells.length > 0) {
                            // Choose a random available cell to make a move.
                            Cell chosenCell = freeCells[random.nextInt(freeCells.length)];
                            // Update the game board with the player's symbol at the chosen cell.
                            game.gameBoard[chosenCell.x][chosenCell.y] = playerSymbol;

                            // Check if the player's move results in a winning condition.
                            if (game.isWinningMove(chosenCell.x, chosenCell.y, playerSymbol)) {
                                System.out.println("Player " + playerSymbol + " wins!");
                                game.printBoard(); // Display the final game board.
                                break;
                            }

                            game.printBoard();
                            game.changeTurn(); // Switch the turn to the other player.

                            if(game.getFreeCells().length == 0)
                                break;

                        } else {
                            System.out.println("Board is full");
                            break;
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class SelfGame extends Game {
    /**
     * Constructor for the SelfGame class.
     * Initializes an instance of the game.
     */
    public SelfGame() {
        super(); // Call the constructor of the superclass (Game).
    }

    /**
     * Implementation of the playGame method for the SelfGame.
     * This method sets up and plays the game between two treats.
     */
    @Override
    public void playGame() {
        // Create SelfPlayer objects for player1 and player2 with symbols 'X' and 'O', respectively.
        Player player1 = new SelfPlayer('X', this); // 'X' symbol for player1.
        Player player2 = new SelfPlayer('O', this); // 'O' symbol for player2.

        // Start the player threads concurrently.
        player1.start();
        player2.start();

        try {
            // Wait for both player threads to complete their moves before proceeding.
            player1.join();
            player2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

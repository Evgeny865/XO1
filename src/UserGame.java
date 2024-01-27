public class UserGame extends Game {
    /**
     * Constructor for the UserGame class.
     * Initializes an instance of the game.
     */
    public UserGame() {
        super(); // Call the constructor of the superclass (Game).
    }

    /**
     * Implementation of the playGame method for the UserGame.
     * This method sets up and plays the game between a UserPlayer and a SelfPlayer.
     */
    @Override
    public void playGame() {
        // Create a UserPlayer with 'X' symbol and a SelfPlayer with 'O' symbol.
        Player player1 = new UserPlayer('X', this); // 'X' symbol for user-controlled player.
        Player player2 = new SelfPlayer('O', this);  // 'O' symbol for self-controlled player.

        // Start both player threads concurrently.
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

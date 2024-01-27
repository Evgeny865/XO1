public abstract class Player extends Thread {
    protected char playerSymbol;  // The symbol ('X' or 'O') associated with the player.
    protected Game game;  // A reference to the game in which the player participates.

    /**
     * Constructor for the Player class.
     *
     * @param playerSymbol The symbol ('X' or 'O') associated with the player.
     * @param game         A reference to the game in which the player will participate.
     */
    public Player(char playerSymbol, Game game) {
        this.playerSymbol = playerSymbol;
        this.game = game;
    }

    /**
     * Abstract method representing the player's behavior during the game.
     * Subclasses must implement this method to define the player's actions.
     */
    @Override
    public abstract void run();
}

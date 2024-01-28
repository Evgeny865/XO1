public abstract class Game {
    protected char[][] gameBoard;
    protected PlayerType currentPlayer;

    public Game() {
        gameBoard = new char[5][5];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                gameBoard[i][j] = ' ';
            }
        }
        currentPlayer = PlayerType.X;
    }
    public abstract void playGame();

    public void printBoard() {
        System.out.println("   0  1  2  3  4");
        System.out.println("  ---------------");
        for (int row = 0; row < 5; row++) {
            System.out.print(row + " |");
            for (int col = 0; col < 5; col++) {
                System.out.printf("%c |", gameBoard[row][col]);
            }
            System.out.println("\n  ---------------");
        }
        System.out.println();
    }

    public PlayerType getTurn(){
        return currentPlayer;
    }

    /**
     * Get an array of free (empty) cells on the game board.
     *
     * @return An array of free cells.
     */
    public Cell[] getFreeCells(){
        Cell[] tempFreeCells = new Cell[25];
        int freeCellCount = 0;

        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(gameBoard[i][j] == ' '){
                    tempFreeCells[freeCellCount++] = new Cell(i,j);
                }
            }
        }
        Cell[] freeCells = new Cell[freeCellCount];
        System.arraycopy(tempFreeCells,0,freeCells,0,freeCellCount);

        return freeCells;
    }
    public void changeTurn() {
        currentPlayer = (currentPlayer == PlayerType.X) ? PlayerType.O : PlayerType.X;
    }

    /**
     * Check if a move at the specified row and column with the given symbol results in a winning move.
     *
     * @param row The row of the move.
     * @param col The column of the move.
     * @param symbol The symbol ('X' or 'O') to check for a winning move.
     * @return true if the move is a winning move, false otherwise.
     */
    public boolean isWinningMove(int row, int col, char symbol) {
        return checkDirection(row, col, 0, 1, symbol) + checkDirection(row, col, 0, -1, symbol) > 3 ||
                checkDirection(row, col, 1, 0, symbol) + checkDirection(row, col, -1, 0, symbol) > 3 ||
                checkDirection(row, col, 1, 1, symbol) + checkDirection(row, col, -1, -1, symbol) > 3 ||
                checkDirection(row, col, 1, -1, symbol) + checkDirection(row, col, -1, 1, symbol) > 3;
    }



    /**
     * Helper method to check for consecutive symbols in a specific direction.
     *
     * @param row The current row.
     * @param col The current column.
     * @param dRow The change in row direction.
     * @param dCol The change in column direction.
     * @param symbol The symbol ('X' or 'O') to check for consecutiveness.
     * @return The count of consecutive symbols in the specified direction.
     */
    private int checkDirection(int row, int col, int dRow, int dCol, char symbol) {
        int nextRow = row + dRow;
        int nextCol = col + dCol;
        if (nextRow < 0 || nextRow >= 5 || nextCol < 0 || nextCol >= 5 || gameBoard[nextRow][nextCol] != symbol) {
            return 0;
        }
        return 1 + checkDirection(nextRow, nextCol, dRow, dCol, symbol);
    }

    /**
     * Enum representing the two players: 'X' and 'O'.
     */
    enum PlayerType {
        X,O;
    }

}



/**
 * Model for tic tac toe
 * 
 * @author Rafay
 * @version 2/23/18
 */
public class TTTModel {
	// Size of one board side
	private final int BOARD_SIZE = 3;

	// Number of same values in a row that counts for a win
	private final int WIN_LENGTH = 3;

	/**
	 * Value corresponding to X, used in printing
	 */
	public static final int X_VALUE = 1;
	/**
	 * Value corresponding to O, used in printing
	 */
	public static final int O_VALUE = 2;

	// Board array to hold values
	private static int[][] gameBoard;

	// Current player
	private boolean isPlayerX;

	/**
	 * Constructor, creates the board size and sets player
	 */
	public TTTModel() {
		// Creates a new, empty board
		gameBoard = new int[BOARD_SIZE][BOARD_SIZE];
		// Sets player to X
		isPlayerX = true;
	}

	/**
	 * Get a string representation of the current player
	 * 
	 * @return string X or O, depending on who's turn it is
	 */
	public String getCurrentPlayer() {
		if (isPlayerX) {
			return "X";
		} else {
			return "O";
		}
	}

	/**
	 * Get the current board
	 * 
	 * @return 2D array holding the board state
	 */
	public static int[][] getBoard() {
		return gameBoard;
	}

	/**
	 * Set the current board
	 * 
	 * @param newBoard
	 *            2D array holding the board state
	 */
	public void setBoard(int[][] newBoard) {
		gameBoard = newBoard;
	}

	/**
	 * This method attempts a round of play. If the attempt fails, the method
	 * returns false
	 * 
	 * @param loc
	 *            location to place the current value
	 * @return If the move was successful
	 */
	public boolean attemptMove(int loc) {
		// Figure out the row and column based on clever math
		// It will work for any BOARD_SIZE, but works like so if BOARD_SIZE = 3:
		// The row (0, 1, or 2) is equal to the loc-1 divided by 3,
		// because ((1, 2, or 3) - 1) / 3 = 0 (first row),
		// because ((4, 5, or 6) - 1) / 3 = 1 (second row),
		// because ((7, 8, or 9) - 1) / 3 = 2 (third row)
		int row = (loc - 1) / BOARD_SIZE;
		// The column (0, 1, or 2) is equal to the loc-1 divided by 3's remainder,
		// because ((1, 4, or 7) - 1) / 3 = 0 (first column),
		// because ((2, 5, or 8) - 1) / 3 = 1 (second column),
		// because ((3, 6, or 9) - 1) / 3 = 2 (third column)
		int col = (loc - 1) % BOARD_SIZE;

		// If the spot is occupied, the move is invalid, so return false
		if (gameBoard[row][col] != 0) {
			return false;
		} else {
			// Fill X or O depending on whose turn it is
			if (isPlayerX) {
				gameBoard[row][col] = X_VALUE;
			} else {
				gameBoard[row][col] = O_VALUE;
			}

			// And the move was valid, so return true
			return true;
		}
	}

	/**
	 * Ends the round, swaps whose turn it is
	 */
	public void endRound() {
		isPlayerX = !isPlayerX;
	}

	/**
	 * Returns true if one player has WIN_LENGTH in a row
	 * 
	 * @return if a player has won the game
	 */
	public boolean isGameWon() {
		return checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin();
	}

	/**
	 * Check the horizonal for a win
	 * 
	 * @return True if there's a horizontal row of WIN_LENGTH
	 */
	private boolean checkHorizontalWin() {
		// initialize int for counting connected values
		int connected = 1;

		// Initialize the previous value, to compare
		int prevValue;

		// Go through each row
		for (int row = 0; row < BOARD_SIZE; row++) {
			// First column can't be compared, so set it as comparison
			prevValue = gameBoard[row][0];
			for (int col = 1; col < BOARD_SIZE; col++) {
				// if current value is same as the previous value, increase the # of connected
				if (gameBoard[row][col] != 0 && gameBoard[row][col] == prevValue) {
					connected++;
					// Check for win condition
					if (connected == WIN_LENGTH) {
						return true;
					}
				} else {
					connected = 1;
				}

				prevValue = gameBoard[row][col];

			}
			connected = 1;// reset connected because end of line is reached
		}
		// if the for loop is over, return false
		return false;
	}

	/**
	 * Check the vertical for a win
	 * 
	 * @return True if there's a vertical column of WIN_LENGTH
	 */
	private boolean checkVerticalWin() {
		// Look at horizonal for an idea
		// initialize int for counting connected values
		int connected = 1;

		// Initialize the previous value, to compare
		int prevValue;

		// Go through each col
		for (int col = 0; col < BOARD_SIZE; col++) {

			prevValue = gameBoard[col][0];
			for (int row = 1; row < BOARD_SIZE; row++) {
				// if current value is same as the previous value, increase the # of connected
				if (gameBoard[row][col] != 0 && gameBoard[row][col] == prevValue) {
					connected++;
					// Check for win condition
					if (connected == WIN_LENGTH) {
						return true;
					}
				} else {
					connected = 1;
				}

				prevValue = gameBoard[row][col];

			}
			connected = 1;// reset connected because end of line is reached
		}
		// if the for loop is over, return false
		return false;
	}

	/**
	 * Check the diagonals for a win INCOMPLETE
	 * 
	 * @return True if there's a diagonal line of WIN_LENGTH
	 */
	private boolean checkDiagonalWin() {
		// This one's trickier; only do this if you have time
		return false;
	}

	/**
	 * Returns true if board is full
	 * 
	 * @return if board is full
	 */
	public boolean isGameOver() {
		// Check all spaces
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				// If any space is empty, the board isn't full
				if (gameBoard[row][col] == 0) {
					return false;
				}
			}
		}
		// If they all are, the board is full, and the game is over
		return true;
	}

}
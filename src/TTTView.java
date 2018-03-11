/**
 * Tic Tac Toe View Class
 * 
 * @author Rafay
 * @version 2/23/18
 */
public class TTTView {
	// The board object from the game
	private TTTModel model;
	public static int[][] gameBoard;

	/**
	 * constructor initializes the board array
	 * 
	 * @param board
	 */
	public TTTView(TTTModel model) {
		this.model = model;
	}

	/**
	 * Print the board to the console
	 * 
	 * @param board
	 */
	public void printBoard() {
		// importing getBoard method from class TTTModel
		int[][] gameBoard = TTTModel.getBoard();
		// for each board row
		for (int i = 0; i < gameBoard.length; i++) {
			// for each board column
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j] == 1) {

					System.out.print("X");
					if (j != gameBoard.length - 1) {
						System.out.print("|");
					}

				} else if (gameBoard[i][j] == 2) {

					System.out.print("O");
					if (j != gameBoard.length - 1) {
						System.out.print("|");
					}
				} else {

					System.out.print(" ");
					if (j != gameBoard.length - 1) {
						System.out.print("|");
					}
				}

			}

			System.out.println();
			if (i != gameBoard.length - 1) {
				System.out.println("-----");
			}

		}
	}

}

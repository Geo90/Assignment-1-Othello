
public class GameState {

	int empty = 0;
	int black = 1;
	int white = 2;

	int player1 = 1;
	int player2 = 2;

	int[][] board = new int[4][4];

	int[] playerScore = new int[2];
	int squaresUnocupied = board.length * board.length;

	int playerTurn = player1;

	public GameState() {

	}

	public int playerMove(int row, int column) {
		if (playerTurn == player1) {
			board[row][column] = white;
		} else
			board[row][column] = black;
		return 0;
	}

	public int[][] getBoard() {
		return board;
	}
}

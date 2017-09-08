
public class GameEngine {

	int empty = 0;
	int black = 1;
	int white = 2;

	private GameState gs = new GameState();

	/**
	 * 
	 * @return
	 */
	public int countDisks() {

		return 0;
	}

	public boolean placeDisk(int row, int column) {
		if (validMove(row, column)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validMove(int row, int column) {
		int[][] board = gs.getBoard();
		if (board[row][column] == empty)
			return true;
		else
			return false;
	}
}

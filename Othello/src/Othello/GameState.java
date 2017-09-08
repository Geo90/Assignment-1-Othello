package Othello;

import static Othello.Values.*;

import java.util.Arrays;

public class GameState {

	private final int BOARDSIZE = 4;
	private final int PLAYERS = 2;
	private int[] board = new int[BOARDSIZE*BOARDSIZE];
	private int[] playerScore;
	private int squaresUnocupied;
	private int playerTurn;

	/**
	 * Initial game state
	 */
	public GameState() {
		playerScore = new int[PLAYERS];
		playerScore[player1.getNumber()-1] = 0; 
		playerScore[player2.getNumber()-1] = 0;
		squaresUnocupied = BOARDSIZE*BOARDSIZE;
		playerTurn = player1.getNumber();
		//board = new int[BOARDSIZE][BOARDSIZE];
		for (int square: board){
         	   square = 0;
		}
	}

	public boolean playerMove(int row, int column) {
		int square = getSquare(row, column);
		if (playerTurn == player1.getNumber()) {
			board[square] = white.getNumber();
		} else
			board[square] = black.getNumber();
		squaresUnocupied--;
		return true;
	}
	
	public int getPlayerScore(){
		return playerScore[playerTurn-1];
	}
	
	public void setPlayerTurn(int playerTurn){
		this.playerTurn = playerTurn;
	}
	
	public int getPlayerTurn(){
		int playerTurn = this.playerTurn;
		return playerTurn; 
	}

	public int[] getBoard() {
		return board;
	}
	
	public int getBoardSize(){
		return BOARDSIZE;
	}
	
	public int getDiscCount(){
		return squaresUnocupied;
	}
	
	/**
	 * Returns the square at the specified row and column
	 * @param row
	 * @param column
	 * @return
	 */
	public int getSquare(int row, int column){
		int square = 0;
		for(int j= 0; j<row; j++)
			for(int i = 0; i<column; i++){
				square++;
			}
		return square;
	}

	@Override
	public String toString() {
		return "GameState [BOARDSIZE=" + BOARDSIZE + ", PLAYERS=" + PLAYERS + ",\n board=" + Arrays.toString(board)
				+ ",\n playerScore=" + Arrays.toString(playerScore) + ", squaresUnocupied=" + squaresUnocupied
				+ ", playerTurn=" + playerTurn + "]";
	}
	
	

		

}

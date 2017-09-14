package Othello;

import static Othello.Values.*;

import java.util.Arrays;

public class GameState {

	private int BOARDSIZE = 4;
	private int PLAYERS = 2;
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
		for (int square: board){
         	   square = empty.getNumber();
		}
	}

	public boolean playerMove(int row, int column) {
		int square = getSquare(row, column);
		if (playerTurn == player1.getNumber()) {
			System.out.println("Placed disk: " + "white");
			board[square] = white.getNumber();
		} else if(playerTurn == player2.getNumber()){
			System.out.println("Placed disk: " + "black");
			board[square] = black.getNumber();
		}else{
			System.out.println("playerMove, Something is wrong");
			squaresUnocupied++;
		}
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
		if(row == 0)
			for(int i = 0; i<column; i++){
				square++;
			}
		else{
			int index = 0;
			for(int j= 0; j<row; j++)
				index++;
			square = column + index*4;
		}		


		return square;
	}
	
	/****************************************************
	 * Methods for cloning the GameState 
	 ****************************************************/
	
	private void cloneBoardSize(int size){
		this.BOARDSIZE = size;
	}
	
	private void clonePlayerCount(int players){
		this.PLAYERS = players;
	}
	
	private void cloneBoard(int[] board){
		int[] clonedBoard = new int[getBoardSize()*getBoardSize()];
		for(int i = 0; i<clonedBoard.length; i++){
			int temp = board[i];
			clonedBoard[i] = temp;
		}
		this.board = clonedBoard;
	}
	
	private void clonePlayerTurn(int playerTurn){
		this.playerTurn = playerTurn;
	}
	
	private void clonePlayerScore(int[] playerScore){
		int[] clonedPlayerScore = new int[playerScore.length];
		for(int i = 0; i < clonedPlayerScore.length; i++){
			int temp = playerScore[i];
			clonedPlayerScore[i] = temp;
		}
		this.playerScore = clonedPlayerScore;
	}
	
	private void cloneSquareUnocupied(int squaresUnocupied){
		this.squaresUnocupied = squaresUnocupied;
	}
	
	public GameState cloneGameState(){
		GameState clone = new GameState();
		clone.clonePlayerTurn(playerTurn);
		clone.cloneBoardSize(BOARDSIZE);
		clone.clonePlayerCount(this.PLAYERS);
		clone.cloneBoard(this.board);
		clone.clonePlayerScore(this.playerScore);
		clone.cloneSquareUnocupied(this.squaresUnocupied);
		
		return clone;
		}
	

	@Override
	public String toString() {
		return "GameState [BOARDSIZE=" + BOARDSIZE + ", PLAYERS=" + PLAYERS + ",\n board=" + Arrays.toString(board)
				+ ",\n playerScore=" + Arrays.toString(playerScore) + ", squaresUnocupied=" + squaresUnocupied
				+ ", playerTurn=" + playerTurn + "]";
	}
	
	

		

}

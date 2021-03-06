package Othello;

import static Othello.Values.*;

import javax.swing.JOptionPane;

public class GameEngine {

	private int counter = 0;
	private GameState gs = new GameState();
	
	
	public GameState copyGameState(){
		return gs.cloneGameState();
	}


	/**
	 * 
	 * @return
	 */
	public int updateDiskCount() {
		return gs.getUnocupiedDiscCount();
	}

	public int getPlayerTurn(){
		return gs.getPlayerTurn();
	}

	public int placeDisk(int row, int column) {
		String debugLocation = "GameEngine, placeDisk(row, column)";
		int playerTurn = gs.getPlayerTurn();
		if (validMove(row, column)) {
			updateBoard(row, column);
			getScorePlayer();
			nextPlayer();
			debug(debugLocation, "\n" + gs.toString()); 
		} else {
			System.out.println("----------------------------------------------------------");
			JOptionPane.showMessageDialog(null, "row: " + row + " column: " + column, "This move is invalid! Please try again.", column);
			playerTurn = invalidMove.getNumber();
		}
		return playerTurn;
	}
	
	private boolean validMove(int row, int column) {
		int[] board = gs.getBoard();
		return validMove(gs.getSquare(row, column));
	}
	
	private boolean validMove(int square){
		int[] board = gs.getBoard();
		if (board[square] == empty.getNumber()){
			return true;
		}
		else{
			return false;
		}
	}
	public int[] getScorePlayer(){
        gs.updateScorePlayer();
	  return gs.getPlayerScore();
     
	}
	
	public int[] getRowColumn(int square){
		int boardSize = gs.getBoardSize();
		int counter = 1;
		int row = 0, column = 0;
		for(int i = 0; i<square; i++){
			if(column >= boardSize-1){
				row++;
				column = 0;
				counter = i;
			}
			else{
				column++;
			}
			counter++;
		}
		int [] rc = {row, column};
		return rc;
	}

	public int[] getBoard(){
		return gs.cloneGameState().getBoard();
	}
	
	private void updateBoard(int row, int column){	
		int[] board = gs.getBoard(); 
		gs.playerMove(row, column);
		int playerTurn = getPlayerTurn();
		int diskColor = 0;
		if(playerTurn == player1.getNumber())
			diskColor = white.getNumber();
		else if(playerTurn == player2.getNumber())
			diskColor = black.getNumber();

		//Checking the 8 possible directions to flip the opponents disks
		for(int p = 0; p<8; p++){
			if(p == 0)//horizontal right
				for(int i = column+2; i<gs.getBoardSize(); i++){
					if(board[gs.getSquare(row, i-1)] != empty.getNumber() && board[gs.getSquare(row, i-1)] != diskColor){
						if(board[gs.getSquare(row, i)] == diskColor){
							for(int turnDisks = column; turnDisks<=i; turnDisks++){
								board[gs.getSquare(row, turnDisks)] = diskColor;
							}
						}
					}else{
						//nothing to turn
						break;
					}
				}
			else if(p == 1)//horizontal left
				for(int i = column-2; i>=0; i--){
					if(board[gs.getSquare(row, i+1)] != empty.getNumber() && board[gs.getSquare(row, i+1)] != diskColor){
						if(board[gs.getSquare(row, i)] == diskColor){
							for(int turnDisks = column; turnDisks>=i; turnDisks--){
								board[gs.getSquare(row, turnDisks)] = diskColor;
							}
						}
					}else{
						break;
					}
				}
			else if(p == 2)//vertical up
				for(int i = row-2; i>=0; i--){
					if(board[gs.getSquare(i+1, column)] != empty.getNumber() && board[gs.getSquare(i+1, column)] != diskColor){
						if(board[gs.getSquare(i, column)] == diskColor){
							for(int turnDisks = row; turnDisks>=i; turnDisks--){
								board[gs.getSquare(turnDisks, column)] = diskColor;
							}
						}
					}else{
						//nothing to turn
						break;
					}
				}
			else if(p == 3)//vertical down
				for(int i = row+2; i<gs.getBoardSize(); i++){
					if(board[gs.getSquare(i-1, column)] != empty.getNumber() && board[gs.getSquare(i-1, column)] != diskColor){
						if(board[gs.getSquare(i, column)] == diskColor){
							for(int turnDisks = row; turnDisks<=i; turnDisks++){
								board[gs.getSquare(turnDisks, column)] = diskColor;
							}
						}
					}else{
						//nothing to turn
						break;
					}
				}
			else if(p == 4){//diagonal down right
				int columnCounter = column+2;
				for(int i = row+2; i<gs.getBoardSize(); i++){
					if(board[gs.getSquare(i-1, columnCounter-1)] != empty.getNumber() && columnCounter<gs.getBoardSize() && board[gs.getSquare(i-1, columnCounter-1)] != diskColor && columnCounter<gs.getBoardSize()){
						if(board[gs.getSquare(i, columnCounter)] == diskColor){
							columnCounter = column+1;
							for(int turnDisks = row+1; turnDisks<=i; turnDisks++){
								board[gs.getSquare(turnDisks, columnCounter)] = diskColor;
								columnCounter++;
							}
						}
					}else{
						//nothing to turn
						break;
					}
					columnCounter++;
				}
			}
			else if(p == 5){//diagonal up right
				int columnCounter = column+2;
				for(int i = row-2; i>=0; i--){
					if(board[gs.getSquare(i+1, columnCounter-1)] != empty.getNumber() && board[gs.getSquare(i+1, columnCounter-1)] != diskColor && columnCounter<gs.getBoardSize()){ 
						if(board[gs.getSquare(i, columnCounter)] == diskColor){
							columnCounter = column+1;
							for(int turnDisks = row-1; turnDisks>=i; turnDisks--){
								board[gs.getSquare(turnDisks, columnCounter)] = diskColor;
								columnCounter++;
							}
						}
					} else{
						//nothing to turn
						break;
					}
					columnCounter++;
				}
			}
			else if(p == 6){//diagonal down left
				int columnCounter = column-2;
				for(int i = row+2; i<gs.getBoardSize(); i++){
					if(board[gs.getSquare(i-1, columnCounter+1)] != empty.getNumber())//check not empty
						if(board[gs.getSquare(i-1, columnCounter+1)] != diskColor)//check not same color
							if(board[gs.getSquare(i, columnCounter)] == diskColor)//check where i disk /w same color is
								if(columnCounter>=0){
									columnCounter = column-1;
									for(int turnDisks = row+1; turnDisks<=i; turnDisks++){
										board[gs.getSquare(turnDisks, columnCounter)] = diskColor;
										columnCounter--;
									}
								}else{
									//nothing to turn
									break;
								}
				}
				columnCounter--;
			}else if(p == 7){//diagonal up left
				int columnCounter = column-2;
				for(int i = row-2; i>=0; i--){
					if(board[gs.getSquare(i+1, columnCounter+1)] != empty.getNumber())
						if(board[gs.getSquare(i+1, columnCounter+1)] != diskColor)
							if(board[gs.getSquare(i, columnCounter)] == diskColor)//check where i disk /w same color is)
								if(columnCounter>=0){
									columnCounter = column-1;
									for(int turnDisks = row-1; turnDisks>=i; turnDisks--){
										board[gs.getSquare(turnDisks, columnCounter)] = diskColor;
										columnCounter--;
									}
								}else{
									//nothing to turn
									break;
								}
				}
				columnCounter--;
			}
		}
	}

	public void nextPlayer(){
		if(gs.getPlayerTurn() == player1.getNumber())
			gs.setPlayerTurn(player2.getNumber());
		else
			gs.setPlayerTurn(player1.getNumber());
	}
	public void debug(String debugLocation, String message){
		System.out.println(debugLocation + ", " + message);
	}
}



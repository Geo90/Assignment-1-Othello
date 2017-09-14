package Othello;

import static Othello.Values.*;

import javax.swing.JOptionPane;

public class GameEngine {

	private int counter = 0;
	private GameState gs = new GameState();

	/**
	 * 
	 * @return
	 */
	public int updateDiskCount() {
		return gs.getDiscCount();
	}

	public int getPlayerTurn(){
		return gs.getPlayerTurn();
	}

	public int placeDisk(int row, int column) {
		String debugLocation = "placeDisk 21";
		debug(debugLocation, "A1");
		int playerTurn = gs.getPlayerTurn();
		if (validMove(row, column)) {
			debug(debugLocation, "B1");
			updateBoard(row, column);
			nextPlayer();
			System.out.println("GameEngine.placeDisk, " + gs.toString());
			debug(debugLocation, "B2");
		} else {
			debug(debugLocation, "C1");
			System.out.println("square value: " + gs.getBoard()[gs.getSquare(row, column)]);
			System.out.println("----------------------------------------------------------");
			JOptionPane.showMessageDialog(null, "row: " + row + " column: " + column, "This move is invalid! Please try again.", column);
			System.out.println("GameEngine.placeDisk, INVALID MOVE " + gs.toString());
			System.out.println("invalidMove");
			playerTurn = invalidMove.getNumber();
			debug(debugLocation, "C2");
		}
		return playerTurn;
	}

	private boolean validMove(int row, int column) {
		String debugLocation = "validMove 44";
		debug(debugLocation, "A1");
		System.out.println("(row, column): (" + row + ", " + column);
		int[] board = gs.getBoard();
		if (board[gs.getSquare(row, column)] == empty.getNumber()){
			debug(debugLocation, "B1");
			return true;
		}
		else{
			debug(debugLocation, "C1");
			return false;
		}
	}

	public int[] getBoard(){
		return gs.cloneGameState().getBoard();
	}

	private void updateBoard(int row, int column){
		String debugLocation = "updateBoard 67";
		debug(debugLocation, "A1");
		int[] board = gs.getBoard(); 
		gs.playerMove(row, column);
		debug(debugLocation, "A2");
		System.out.println("(row, column): (" + row + ", " + column);
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
								debug(debugLocation, "B_horizontal_right: " + row + ", " + turnDisks);
							}
						}
					}else{
						debug(debugLocation, "BREAK!!!");
						break;
					}
				}
			else if(p == 1)//horizontal left
				for(int i = column-2; i>=0; i--){
					if(board[gs.getSquare(row, i+1)] != empty.getNumber() && board[gs.getSquare(row, i+1)] != diskColor){
						if(board[gs.getSquare(row, i)] == diskColor){
							for(int turnDisks = column; turnDisks>=i; turnDisks--){
								board[gs.getSquare(row, turnDisks)] = diskColor;
								debug(debugLocation, "C_horizontal_left: " + row + ", " + turnDisks);
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
								debug(debugLocation, "B_vertical_up: " + turnDisks + ", " + column);
							}
						}
					}else{
						break;
					}
				}
			else if(p == 3)//vertical down
				for(int i = row+2; i<gs.getBoardSize(); i++){
					if(board[gs.getSquare(i-1, column)] != empty.getNumber() && board[gs.getSquare(i-1, column)] != diskColor){
						if(board[gs.getSquare(i, column)] == diskColor){
							for(int turnDisks = row; turnDisks<=i; turnDisks++){
								board[gs.getSquare(turnDisks, column)] = diskColor;
								debug(debugLocation, "B_vertical_down: " + turnDisks + ", " + column);
							}
						}
					}else{
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
								debug(debugLocation, "C_diagonal down right: " + turnDisks + ", " + columnCounter);
								columnCounter++;
							}
						}
					}else{
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
								debug(debugLocation, "D_diagonal up right: " + turnDisks + ", " + columnCounter);
								columnCounter++;
							}
						}
					} else{
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
										debug(debugLocation, "E_diagonal down left: " + turnDisks + ", " + columnCounter);
										columnCounter--;
									}
								}else{
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
									debug(debugLocation + " 191, " , "diagonal up left, columnCounter: " + columnCounter);
									columnCounter = column-1;
									for(int turnDisks = row-1; turnDisks>=i; turnDisks--){
										board[gs.getSquare(turnDisks, columnCounter)] = diskColor;
										debug(debugLocation, "F_diagonal up left: " + turnDisks + ", " + columnCounter);
										columnCounter--;
									}
								}else{
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



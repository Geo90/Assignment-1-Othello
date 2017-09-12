package Othello;

import static Othello.Values.*;

import javax.swing.JOptionPane;

public class GameEngine {

	private GameState gs = new GameState();
	
	/**
	 * 
	 * @return
	 */
	public int updateDiskCount() {
		return gs.getDiscCount();
	}

	public boolean placeDisk(int row, int column) {
		if (validMove(row, column)) {
			updateBoard(row, column);
			nextPlayer();
			return true;
		} else {
			JOptionPane.showMessageDialog(null, this, "This move is invalid! Please try again.", column);
			return false;
		}
	}

	private boolean validMove(int row, int column) {
		int[] board = gs.getBoard();
		if (gs.getSquare(row, column) == empty.getNumber())
			return true;
		else
			return false;
	}
	
	private void updateBoard(int row, int column){
		int[] board = gs.getBoard(); 
		gs.playerMove(row, column);
		if(gs.getPlayerTurn() == player1.getNumber()){	
			board[gs.getSquare(row, column)] = white.getNumber();
		}			
		else{
			board[gs.getSquare(row, column)] = black.getNumber();
		}
		for(int p = 0; p<8; p++){
			if(p == 0)
				for(int i = column; i<gs.getBoardSize(); i++){
					if(gs.getPlayerTurn() == black.getNumber() && gs.getSquare(row, i) == black.getNumber()){
						for(int turnDisks = i; turnDisks>column; turnDisks--){
							board[gs.getSquare(row, turnDisks)] = gs.getPlayerTurn();
						}
					}
				}
				for(int i = column; i>=0; i--){
					if(gs.getPlayerTurn() == black.getNumber() && gs.getSquare(row, i) == black.getNumber()){
						for(int turnDisks = i; turnDisks<column; turnDisks++){
							board[gs.getSquare(row, turnDisks)] = gs.getPlayerTurn();
						}
					}
				}
				for(int i = row; i>=0; i--){
					if(gs.getPlayerTurn() == black.getNumber() && gs.getSquare(i, row) == black.getNumber()){
						for(int turnDisks = i; turnDisks<row; turnDisks++){
							board[gs.getSquare(turnDisks, column)] = gs.getPlayerTurn();
						}
					}
				}
				for(int i = row; i>=0; i--){
					if(gs.getPlayerTurn() == black.getNumber() && gs.getSquare(i, column) == black.getNumber()){
						for(int turnDisks = i; turnDisks<column; turnDisks++){
							board[gs.getSquare(turnDisks, column)] = gs.getPlayerTurn();
						}
					}
				}
		}
	}
	
	public void nextPlayer(){
		if(gs.getPlayerTurn() == player1.getNumber())
			gs.setPlayerTurn(player2.getNumber());
		else
			gs.setPlayerTurn(player1.getNumber());
	}
		
}
	


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
		if(gs.getPlayerTurn() == player1.getNumber())
			board[gs.getSquare(row, column)] = white.getNumber();
		else
			board[gs.getSquare(row, column)] = black.getNumber();
		
		for(int p = 0; p<8; p++){
		}
	}
	
	public void nextPlayer(){
		if(gs.getPlayerTurn() == player1.getNumber())
			gs.setPlayerTurn(player2.getNumber());
		else
			gs.setPlayerTurn(player1.getNumber());
	}
	
}

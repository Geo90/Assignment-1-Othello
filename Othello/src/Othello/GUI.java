package Othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static Othello.Values.*;

import java.util.Arrays;

public class GUI extends JPanel implements ActionListener {

	GameState gamestate= new GameState();
	GameEngine gameengine = new GameEngine();
	private boolean playWithAgent = true;
	
	int player1score=0;
	int player2score=0;

	int plate[][] = new int[gamestate.getBoardSize()][gamestate.getBoardSize()];

	private JFrame frame = new JFrame("Othello");
	private JPanel pnl = new JPanel();
	private JPanel pnlnorth = new JPanel();
	private JPanel pnlvänster = new JPanel();
	private JPanel pnlbtn = new JPanel();

	private JButton[][] arrbtn2 = new JButton[gamestate.getBoardSize()][gamestate.getBoardSize()];
	private JButton btnstart = new JButton("Starta spel");

	private JLabel lblplayer1 = new JLabel("Player 1");
	private JLabel lblplayer2 = new JLabel("Player 2");
	private JLabel score1= new JLabel("score1");
	private JLabel score2= new JLabel("score2");

	public void GUI() {
		pnl.setBounds(0, 60, 550, 500);
		pnl.setLayout(new GridLayout(4, 4));
		pnl.setVisible(true);
		pnlvänster.setLayout(new GridLayout(3,2));        		
		pnlvänster.setVisible(true);
		pnlvänster.setBackground(Color.RED);
		btnstart.setPreferredSize(new Dimension(50,50));

		for(int row=0; row<arrbtn2.length; row++) {
			for(int col=0; col<arrbtn2[row].length; col++) {			
				pnl.add( arrbtn2[row][col] = new JButton());
				arrbtn2[row][col].setBackground(Color.GREEN);
				arrbtn2[row][col].addActionListener(this);
			}
			btnstart.addActionListener(this);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.pack();

			pnlvänster.add(lblplayer1);
			pnlvänster.add(lblplayer2);
			pnlvänster.add(score1);
			pnlvänster.add(score2);
			pnlvänster.add(btnstart);

			frame.setSize(new Dimension(600, 600));
			frame.add(pnl);
			frame.add(pnlvänster, BorderLayout.NORTH);
			frame.repaint();
		}
	}
	
	public void resetGame(){
		frame.remove(pnl);
		pnl = new JPanel();
		pnl.setBounds(0, 60, 550, 500);
		pnl.setLayout(new GridLayout(4, 4));
		pnl.setVisible(true);
		for(int row=0; row<arrbtn2.length; row++) {
			for(int col=0; col<arrbtn2[row].length; col++) {			
				pnl.add( arrbtn2[row][col] = new JButton());
				arrbtn2[row][col].setBackground(Color.GREEN);
				arrbtn2[row][col].addActionListener(this);
			}
		}
		frame.add(pnl);
	}

	public  void actionPerformed(ActionEvent e){
		if(e.getSource()==btnstart){
			gameengine = new GameEngine();
			resetGame();
		}

		for(int row=0; row<arrbtn2.length; row++) {
			for(int col=0; col<arrbtn2[row].length; col++) {

				if(e.getSource()==arrbtn2[row][col]){			
					int validMove = 0;

					if(gameengine.getPlayerTurn() == player1.getNumber()){
						System.out.println("--- HUMAN PLAYER ---");
						validMove = gameengine.placeDisk(row,col);
						if(validMove != -1 ){
							arrbtn2[row][col].setBackground(Color.white);
						}
					}else if(gameengine.getPlayerTurn() == player2.getNumber() && playWithAgent == false){
						System.out.println("--- HUMAN PLAYER ---");
						validMove = gameengine.placeDisk(row,col);
						if(validMove != -1 ){
							arrbtn2[row][col].setBackground(Color.black);
						}
					}

					if(gameengine.getPlayerTurn() == player2.getNumber()  && playWithAgent){
						System.out.println("------------------- AGENT PLAYER");
						
						//Make the agent wait
						long currentTime = System.currentTimeMillis();
						long pastTime = currentTime;
						while(currentTime-pastTime<1000)
							currentTime = System.currentTimeMillis();
						
						MiniMaxAgent mmAgent = new MiniMaxAgent(gameengine);
						int[] rc = gameengine.getRowColumn(mmAgent.agentMove());
						validMove = gameengine.placeDisk(rc[0], rc[1]);
					}
				}
			}	
		}
		score1.setText(Integer.toString(gameengine.getScorePlayer()[player1.getNumber()-1]));
		score2.setText(Integer.toString(gameengine.getScorePlayer()[player2.getNumber()-1]));

		int[] board = gameengine.getBoard();
		int row = 0;
		int column = 0;
		for(int index = 0; index<board.length; index++){
			if(board[index] == player1.getNumber())
				arrbtn2[row][column].setBackground(Color.white);
			else if(board[index] == player2.getNumber()){
				arrbtn2[row][column].setBackground(Color.black);
			}
			column++;
			if(column > 3){
				row++;
				column = 0;
			}
		}
	}

	public void debug(String debugLocation, String message){
		System.out.println(debugLocation + ", " + message);
	}
}
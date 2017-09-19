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

private int counter = 0;
	int black = 1;
	int white = 2;
	int EMPTY = 0;
	int rutor = 16;
	
	int player1score=0;
    int player2score=0;

	int plate[][] = new int[gamestate.getBoardSize()][gamestate.getBoardSize()];

	private JFrame frame = new JFrame("Othello");
	private JPanel pnl = new JPanel();
	private JPanel pnlnorth = new JPanel();
    private JPanel pnlvänster = new JPanel();
    private JPanel pnlbtn = new JPanel();
	JButton[][] arrbtn2 = new JButton[gamestate.getBoardSize()][gamestate.getBoardSize()];
	
	//JButton[][] arrbtn2 = new JButton[4][4];


	JButton btnstart = new JButton("Starta spel");

	JLabel lblplayer1 = new JLabel("Player 1");
	JLabel lblplayer2 = new JLabel("Player 2");
	 JLabel score1= new JLabel("score1");
	 JLabel score2= new JLabel("score2");
  


	public void GUI() {

		pnl.setLayout(new GridLayout(4, 4));
		pnl.setVisible(true);
		pnl.setBounds(0, 60, 550, 500);
		
		 pnlvänster.setLayout(new GridLayout(3,2));        		
         pnlvänster.setVisible(true);
		 pnlvänster.setBackground(Color.RED);

		 
		 btnstart.setPreferredSize(new Dimension(50,50));
		 
		

		//lblplayer1.setBounds(20, 0, 5, 5);


		for(int row=0; row<arrbtn2.length; row++) {
			for(int col=0; col<arrbtn2[row].length; col++) {			

				pnl.add( arrbtn2[row][col] = new JButton());
				arrbtn2[row][col].setBackground(Color.GREEN);

				arrbtn2[row][col].addActionListener(this);
			}
			btnstart.addActionListener(this);
            

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			//frame.setSize(new Dimension(700,700));
			frame.pack();
			
	       // pnlvänster.add(btnstart);
	        pnlvänster.add(lblplayer1);
	        pnlvänster.add(lblplayer2);
	        pnlvänster.add(score1);
	        pnlvänster.add(score2);
	        pnlvänster.add(btnstart);
	        
	    	frame.setSize(new Dimension(600, 600));
			
			
			frame.add(pnl);
			frame.add(pnlvänster, BorderLayout.NORTH);
			frame.repaint();
			//pnl.repaint();
			

		}
	}

	public  void actionPerformed(ActionEvent e){
		
		if(e.getSource()==btnstart){
			for(int row=0; row<arrbtn2.length; row++) {
				for(int col=0; col<arrbtn2[row].length; col++) {
					arrbtn2[row][col].setBackground(Color.green);
					System.out.print("hääääär");
				}
		}}

		for(int row=0; row<arrbtn2.length; row++) {
			for(int col=0; col<arrbtn2[row].length; col++) {
                  
				if(e.getSource()==arrbtn2[row][col]){			
					int validMove = 0;
					if(gameengine.getPlayerTurn() == player1.getNumber()){
						debug("GUI 103", "A");
						validMove = gameengine.placeDisk(row,col);
						
						System.out.println("rad="+ row + " "+" col" + col + "  " + "spelare "+" "+  player1.getNumber());
						if(validMove != -1 ){
							arrbtn2[row][col].setBackground(Color.white);
						debug("GUI 103", "A_END");
						

						}
					}else if(gameengine.getPlayerTurn() == player2.getNumber()){
						debug("GUI 103", "B1");
						validMove = gameengine.placeDisk(row,col);
						
						System.out.println("rad="+ row + " "+" col" + col + "  " +"spelare"+" " +  player2.getNumber());
						if(validMove != -1 ){
							arrbtn2[row][col].setBackground(Color.black);
						debug("GUI 103", "B_END");
						
						}
						
           

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
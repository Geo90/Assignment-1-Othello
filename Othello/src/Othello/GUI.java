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

	int plate[][] = new int[gamestate.getBoardSize()][gamestate.getBoardSize()];

	private JFrame frame = new JFrame("Othello");
	private JPanel pnl = new JPanel();
	private JPanel pnlnorth = new JPanel();

	JButton[] arrbtn = new JButton[16];
	JButton[][] arrbtn2 = new JButton[4][4];


	JButton btnstart = new JButton("Starta spel");

	JLabel lblplayer1 = new JLabel("Player 1");
	JLabel lblplayer2 = new JLabel("Player 2");
	private JLabel score1= new JLabel("score1");
	private JLabel score2= new JLabel("score2");



	public void GUI() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(new Dimension(700,700));
		frame.pack();

		pnl.setLayout(new GridLayout(4, 4));
		pnl.setVisible(true);
		// pnl.setPreferredSize(new Dimension(500,500));
		pnl.setBounds(0, 60, 580, 500);

		pnlnorth.add(btnstart);
		pnlnorth.add(lblplayer1);
		pnlnorth.add(lblplayer2);

		frame.setSize(new Dimension(600, 600));

		lblplayer1.setBounds(20, 0, 5, 5);

		btnstart.addActionListener(this);

		for(int row=0; row<arrbtn2.length; row++) {
			for(int col=0; col<arrbtn2[row].length; col++) {			

				pnl.add( arrbtn2[row][col] = new JButton());
				arrbtn2[row][col].setBackground(Color.GREEN);

				arrbtn2[row][col].addActionListener(this);
			}

			pnlnorth.add(btnstart);

			pnlnorth.add(lblplayer1);

			pnlnorth.add(lblplayer2);

			pnlnorth.add(score1);

			pnlnorth.add(score2);

			frame.add(pnl);
			frame.add(pnlnorth);
			frame.repaint();
			//pnl.repaint();
		}
	}

	public  void actionPerformed(ActionEvent e){


		for(int row=0; row<arrbtn2.length; row++) {
			for(int col=0; col<arrbtn2[row].length; col++) {

				if(e.getSource()==arrbtn2[row][col]){			
					int validMove = 0;
					if(gameengine.getPlayerTurn() == player1.getNumber()){
						debug("GUI 103", "A");
						validMove = gameengine.placeDisk(row,col);
						System.out.println("rad="+ row + " "+" col" + col + "  " + "spelare "+" "+  player1.getNumber());
						if(validMove != -1 )
							arrbtn2[row][col].setBackground(Color.white);
						debug("GUI 103", "A_END");
					}else if(gameengine.getPlayerTurn() == player2.getNumber()){
						debug("GUI 103", "B1");
						validMove = gameengine.placeDisk(row,col);
						System.out.println("rad="+ row + " "+" col" + col + "  " +"spelare"+" " +  player2.getNumber());
						if(validMove != -1 )
							arrbtn2[row][col].setBackground(Color.black);
						debug("GUI 103", "B_END");
					}
				}
			}	
		}
		
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
		
		// if(gamestate.getPlayerTurn()== player1.getNumber()){
		/**	   int index= 0;
    		   for(int row=0;row<4;row++){
    			   for(int col = 0;col<4;col++){
    				 if(index==i){ 

    					 if( gameengine.placeDisk(row,col)){

     		    		    System.out.println("rad"+ row + "col " + col  + " i = " + i );
    						 if(gamestate.getPlayerTurn()==player1.getNumber()){
    						 arrbtn[i].setBackground(Color.BLACK); 

    				   break;}
    				 }else if(gamestate.getPlayerTurn()==player2.getNumber()){
 		    		    System.out.println("rad"+ row + "col " + col  + " i = " + i );
    					 arrbtn[i].setBackground(Color.WHITE);
    					 break;
    				 }
    					 }
    				 index++;

    			   }

    		   }


    		  // arrbtn[i].setBackground(Color.BLACK); 
    	       //  gamestate.setPlayerTurn(player2.getNumber());



       }else if( gamestate.getPlayerTurn()== player2.getNumber()){
    	  int index=0;
    	   for(int row=0;row<4;row++){
			   for(int col = 0;col<4;col++){
				 if(index==i){ 
					 if( gameengine.placeDisk(col,row)){

					 arrbtn[i].setBackground(Color.WHITE); 
			          // gamestate.setPlayerTurn(player1.getNumber());
				   break;
				 }}
				 index++;

			   }**/




		if(e.getSource()==btnstart){

			for(int i =0;i<arrbtn.length;i++){

				arrbtn[i].setBackground(Color.GREEN);
			}
		}

	}
	public void debug(String debugLocation, String message){
		System.out.println(debugLocation + ", " + message);
	}
}
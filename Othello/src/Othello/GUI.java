package Othello;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel implements ActionListener {

	int height = 4;
	int width = 4;
	int black = 1;
	int white = 2;
	int EMPTY = 0;
	int rutor = 16;
	int plate[][] = new int[width][height];

	private JFrame frame = new JFrame("Othello");
	private JPanel pnl = new JPanel();
	private JPanel pnlnorth = new JPanel();

	JButton[] arrbtn = new JButton[16];

	JButton btnstart = new JButton("Starta spel");

	JLabel lblplayer1 = new JLabel("Player 1");
	JLabel lblplayer2 = new JLabel("Player 2");
	private JLabel score1= new JLabel("score1");
	private JLabel score2= new JLabel("score2");

	public void GUI() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(new Dimension(600,600));

		pnl.setLayout(new GridLayout(4, 4));
		pnl.setVisible(true);
		// pnl.setSize(new Dimension(500,500));
		pnl.setBounds(0, 60, 580, 500);

		pnlnorth.add(btnstart);
		pnlnorth.add(lblplayer1);
		pnlnorth.add(lblplayer2);

		frame.setSize(new Dimension(600, 600));

		lblplayer1.setBounds(20, 0, 5, 5);

		// btn.setSize(new Dimension(30,30));
	    btnstart.addActionListener(this);
	    
		for (int i = 0; i < arrbtn.length; i++) {
			
			pnl.add(arrbtn[i] = new JButton());
			 
		      arrbtn[i].setBackground(Color.GREEN);
		 
		      arrbtn[i].addActionListener(this);
		 
		}

		
		 pnlnorth.add(btnstart);
		 
	      pnlnorth.add(lblplayer1);
	 
	      pnlnorth.add(lblplayer2);
	 
	      pnlnorth.add(score1);
	 
	      pnlnorth.add(score2);

		frame.add(pnl);
		frame.add(pnlnorth);

	}
	
    public  void actionPerformed(ActionEvent e){
    	 
        
    	 
        for(int i =0;i<arrbtn.length;i++){
   
       
   
       if(e.getSource()==arrbtn[i]){
   
        arrbtn[i].setBackground(Color.BLACK); 
   
       }
   
       }
   
      if(e.getSource()==btnstart){
   
        for(int i =0;i<arrbtn.length;i++){
   
          arrbtn[i].setBackground(Color.GREEN);
   
          
   
        }
   
      }
   
      }
   
      
   

}
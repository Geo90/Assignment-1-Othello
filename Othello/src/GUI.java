package AILabb1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JPanel{
	
	int height = 4 ;
	int width =  4 ;
     int black = 1;          
     int white = 2;
     int EMPTY = 0;
     int rutor=16;
     int plate[][] = new int[width][height];
     
    private JFrame frame= new JFrame("Othello");
    private JPanel pnl=new JPanel();
    private JPanel pnlnorth = new JPanel();
    
     JButton[] arrbtn= new JButton[16];
     
     JButton btnstart= new JButton("Starta spel");
     
     JLabel lblplayer1=  new JLabel("Player 1");
     JLabel lblplayer2=  new JLabel("Player 2");
     
    public void GUI(){
    	
  	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
  	  frame.setVisible(true);
    	
    	pnl.setLayout(new GridLayout(4,4));
        pnl.setVisible(true); 
      //  pnl.setSize(new Dimension(500,500));
        pnl.setBounds(0, 60, 580, 500);
        
      
        
        
        
  
        pnlnorth.add(btnstart);
        pnlnorth.add(lblplayer1);
        pnlnorth.add(lblplayer2);
        
        
        
        frame.setSize(new Dimension(600,600));
	
        lblplayer1.setBounds(20, 0, 5, 5);

	
	  //btn.setSize(new Dimension(30,30));
	  
	  for(int i =0;i<arrbtn.length;i++){
		  pnl.add(new JButton());
	  }
	   
	  
	  
	     
	     
	   frame.add(pnl);
	   frame.add(pnlnorth);
		  
     }
     
     public static void main (String []args){

  GUI play= new GUI();
  //JFrame frame= new JFrame("Othello");
  //frame.setSize(800, 800);
  //Container cont= frame.getContentPane();
  //cont.add(frame);
  //frame.setVisible(true);
  play.GUI();
 

}}
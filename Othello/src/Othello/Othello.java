package Othello;

class Othello {
	private static GameState gState;
	private static GameEngine gEngine;
	private static GUI play;
	
	public static void main(String[] args) {
		startGame();
		//Print out the current status of the board
		System.out.println(gState.toString());

		
	/*	 BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
	        bst.put( new Integer(50), new Integer(50) );
	        bst.put( new Integer(30), new Integer(30) );
	        bst.put(new Integer(10), new Integer(10) );
	        bst.put( new Integer(70), new Integer(70) );
	        bst.put( new Integer(20), new Integer(20) );
	        bst.put( new Integer(40), new Integer(40) );
	        bst.put( new Integer(60), new Integer(60) );
	        bst.put( new Integer(80), new Integer(80) );
	        bst.put( new Integer(75), new Integer(75) );
	        

	        
	        bst.root().print();
	        bst.root().showTree();*/
	}
	
	public static void startGame(){
		gState = new GameState();
		gEngine = new GameEngine(); //gets the current GameState and is used to update the board every move
		//MiniMaxAgent mmAgent = new MiniMaxAgent(gState);//the algorithm agent
		HumanAgent hAgent = new HumanAgent();//gets the current GameState and shows it to the user every move
	}
	
	public static void tick(){
		while(true){
			
		}
	}
}

package Othello;

class Othello {
	private static GameState gState;
	private static GameEngine gEngine;
	private static GUI play;

	public static void main(String[] args) {
		startGame();
		//Print out the current status of the board
		System.out.println(gState.toString());

	}
	
	public static void startGame(){
		gState = new GameState();
		gEngine = new GameEngine(); //gets the current GameState and is used to update the board every move
		HumanAgent hAgent = new HumanAgent();//gets the current GameState and shows it to the user every move
		MiniMaxAgent mmAgent = new MiniMaxAgent();//the algorithm agent
	}
	
	public static void tick(){
		while(true){
			
		}
	}
}

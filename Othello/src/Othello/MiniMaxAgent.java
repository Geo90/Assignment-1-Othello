package Othello;

public class MiniMaxAgent {

	GameState clonedGameState;
	int depth = 3;
	int utilityValue = 0;
	int alpha = 0;
	int beta = 0;
	
	public MiniMaxAgent(GameState gameState){
		clonedGameState = gameState.cloneGameState(); 
	}
	
	/**
	 * Calculating the value of a move.
	 * Value = 0, nothing happens,
	 * Value = -1, opponent scores,
	 * Value = +1, agent scores,
	 */
	private void utilityFunction(){
		
	}
	
	private void simulateMove(){
		
	}
	
	private void alphaBetaPruning(){
		
	}
}

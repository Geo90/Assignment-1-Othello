package Othello;

public class MiniMaxAgent {

	GameState clonedGameState;
	int depth = 3;
	int utilityValue = 0;
	int min = 0;
	int max = 0;
	
	public int agentMove(){
		int index = 0;
		int[] unocupiedSquare = new int[clonedGameState.getUnocupiedDiscCount()];
		for(int i = 0; i<clonedGameState.getBoard().length; i++){
			if(clonedGameState.getBoard()[i] == 0){
				System.out.print(i +", ");
				unocupiedSquare[index] = i;
				index++;
			}
		}
		int random = (int)Math.floor(Math.random()*unocupiedSquare.length);
		return unocupiedSquare[random];
	}
	
	public MiniMaxAgent(GameEngine gameEngine){
		clonedGameState = gameEngine.copyGameState(); 
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

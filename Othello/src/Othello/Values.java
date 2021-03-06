package Othello;

public enum Values {
	empty(0), white(1), black(2), player1(1), player2(2), invalidMove(-1);

	private final int number;

	private Values(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}

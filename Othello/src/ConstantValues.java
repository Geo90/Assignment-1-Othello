
public enum ConstantValues {
	empty(0), white(1), black(2), player1(1), player2(2);

	private final int number;

	private ConstantValues(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}

package laboration14;

public class Room {
    private int weight;
    private boolean left;
    private boolean up;
    private boolean right;
    private boolean down;

    public Room(int weight, boolean left, boolean up, boolean right,
            boolean down) {
        this.weight = weight;
        this.left = left;
        this.up = up;
        this.right = right;
        this.down = down;
    }

    public boolean getDown() {
        return down;
    }

    public boolean getLeft() {
        return left;
    }

    public boolean getRight() {
        return right;
    }

    public boolean getUp() {
        return up;
    }

    public int getWeight() {
        return weight;
    }
}

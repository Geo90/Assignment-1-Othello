package Othello;



public class Node<K, V> {
	K key;
	V value;
	Node<K, V> left;
	Node<K, V> right;

	public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public int height() {
		int leftH = -1, rightH = -1;
		if (left != null)
			leftH = left.height();
		if (right != null)
			rightH = right.height();
		return 1 + Math.max(leftH, rightH);
	}

	public int size() {
		int leftS = 0, rightS = 0;
		if (left != null)
			leftS = left.size();
		if (right != null)
			rightS = right.size();
		return 1 + leftS + rightS;
	}

	public void print() {
		if (left != null)
			left.print();
		System.out.println(key + ": " + value);
		if (right != null)
			right.print();
	}

	public void showTree() {
		javax.swing.JOptionPane.showMessageDialog(null, new ShowBSTNode<K, V>(this, 800, 600), "Show tree",
				javax.swing.JOptionPane.PLAIN_MESSAGE);
	}
}

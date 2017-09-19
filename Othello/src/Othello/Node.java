package Othello;




public class Node<K, V> {
	K key;
	V value;
	Node<K, V>[] children;

	public Node(K key, V value, Node<K, V>[] children) {
		this.key = key;
		this.value = value;
		this.children = children;
	}

	public int height() {
		int[] height = new int[children.length];
		for(int i = 0; i<height.length; i++){
			if (children[i] != null)
				height[i] = children[i].height();
		}
		int max = 0;
		for(int i = 0; i<height.length-1; i++){
			if(height[i]>height[i+1])
				max = height[i];
			else
				max = height[i+1];
		}
		return 1 + max;
	}
/*
	public int size() {
		int leftS = 0, rightS = 0;
		if (node[0] != null)
			leftS = node[0].size();
		if (node[node.length-1] != null)
			rightS = node[node.length-1].size();
		return 1 + leftS + rightS;
	}
*/
	
	public void print() {
		for(int i = 0; i<children.length-1; i++){
		if (children[i] != null)
			children[i].print();
		System.out.println(key + ": " + value );
		}
	}
}

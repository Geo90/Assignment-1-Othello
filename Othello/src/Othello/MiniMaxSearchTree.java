package Othello;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static Othello.Values.*;

import collections.ArrayList;

public class MiniMaxSearchTree<K, V> {
	private String debugLocation = "MiniMaxSearchTree";
	private String debugMessage = "none";
	private int numberOfPossibilities = 0;

	private static int key = 0;
	private Comparator<K> comparator;
	private Node<K, V> tree;
	private Node<K, V>[] children;
	private int depth = 5;

	/**
	 * Constructor for the class MiniMaxSearchTree
	 * @param numberOfPossibilities
	 */
	public MiniMaxSearchTree(int numberOfPossibilities) {
		this.numberOfPossibilities = numberOfPossibilities;
	//	comparator = new Comp();
		children = new Node[numberOfPossibilities];
	}

	/**
	 * Sets the number of moves that should be evaluated at every node of the tree
	 * @param numberOfPossibilities
	 */
	public void setNumberOfPossibilities(int numberOfPossibilities){
		this.numberOfPossibilities = numberOfPossibilities;
	}

	public Node<K, V> root() {
		return tree;
	}

	public void add(K key, V value) {
		tree = add(tree, key, value);        
	} 

	private Node<K, V> add(Node<K, V> node, K key, V value) {
		if( node == null ) {
			node = new Node<K, V>( key, value, new Node[numberOfPossibilities]);
			debug(debugLocation + "node " , node.toString());
		} else {
			int i = 0;
			while(node.children[i] == null && i < numberOfPossibilities){
				debug(debugLocation + "node", node.toString());
				debug(debugLocation + "key", key.toString());
				debug(debugLocation + "value", value.toString());
				debug(debugLocation + "node child", node.children[i].toString());
				debug(debugLocation + "key child", node.children[i].key.toString());
				debug(debugLocation + "value child", node.children[i].value.toString());
				
				node = add(node, key, value);
				i++;
			} 
		}
		return node;
	}

	//empty method
	private void keys(Node<K, V> node, ArrayList<K> list){}
	

	public static void main(String[] args) {
		int numberOfChildren = 5;
		MiniMaxSearchTree<Integer, GameState> mmst = new MiniMaxSearchTree<Integer, GameState>(numberOfChildren);
		
		
		GameEngine gEngine = new GameEngine();
		GameState gState = gEngine.copyGameState();
		
		Node nRoot = new Node(key, gState, new Node[numberOfChildren]);
		
		String debugLocation = mmst.debugLocation = "MiniMaxSearchTree, Main ";
		String debugMessage = mmst.debugMessage = "nRoot number of children: " + nRoot.children.length;
		mmst.debug(debugLocation, debugMessage);
		
		debugMessage = mmst.debugMessage = "nRoot.key: " + nRoot.key;
		mmst.debug(debugLocation, debugMessage);
		
		debugMessage = mmst.debugMessage = "nRoot.value: " + nRoot.value;
		mmst.debug(debugLocation, debugMessage);
		
		GameState gsValue = (GameState)nRoot.value;
		debugMessage = mmst.debugMessage = "gsValue.getPlayerTurn(): " + gsValue.getPlayerTurn();;
		mmst.debug(debugLocation, debugMessage);
		
		
		mmst.add(key, gState);
		key++;
		//System.exit(0);
		
		int index = 0;
		int[] unocupiedSquare = new int[gState.getUnocupiedDiscCount()];
		for(int i = 0; i<gState.getUnocupiedDiscCount(); i++){
			if(gState.getBoard()[i] == 0){
				unocupiedSquare[index] = gState.getBoard()[i];
				index++;
			}
		}
		
		/*
		gState = mmst.newMove(gState, row, column);
		mmst.add(0, gs);


		gs = mmst.newMove(ge, row, column);
		//mmst.add(0, gs);

		gs = mmst.newMove(ge, row, column);
		//mmst.add(0, gs);

		gs = mmst.newMove(ge, row, column);
		//mmst.add(0, gs);
		 * 
		 */
	}

	public GameState newMove(GameEngine ge, int square){
		//ge.placeDisk(square);
		return ge.copyGameState();
	}


	public void debug(String debugLocation, String debugMessage){
		System.out.println(debugLocation + ": " + debugMessage);
	}
}

/*


	public MiniMaxSearchTree( Comparator<K> comp ) {
		comparator = comp;
	}


	public Iterator<V> iterator() {
		return new Iter();
	}
	
	
    public List<K> keys(){
    	ArrayList<K> list = new List<K>();
    	keys(tree, list);
        return list;
    }

private class Comp implements Comparator<K> {
	public int compare( K key1, K key2 ) {
		Comparable<K> k1 = ( Comparable<K> )key1;
		return k1.compareTo( key2 );
	}
}

public V get(K key) {
    Node<K, V> node = find( key );
    if(node!=null)
        return node.value;
    return null;
}


private Node<K,V> find(K key) {
    int res;
    int index = numberOfPossibilities;
    Node<K,V> node=tree;
    while( ( node != null ) && ( ( res = comparator.compare( key, node.key ) ) != 0 ) ) {
        if( res < 0 )
            node = node.left;
        else
            node = node.right;
    }
    return node;
}

private class Iter implements Iterator<V> {
	ArrayList<V> list = new ArrayList<V>();
	int index = -1;

	public Iter() {
		inOrder(tree);
	}

	private void inOrder(Node<K, V> tree) {
		// TODO Auto-generated method stub

	}

	public boolean hasNext() {
		return index<list.size()-1;
	}

	public V next() {
		if(!hasNext())
			throw new NoSuchElementException();
		index++;
		return list.get(index);
	}
}
*/
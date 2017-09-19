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

	private Comparator<K> comparator;
	private Node<K, V> tree;
	private Node<K, V>[] children;
	private int depth = 5;

	public MiniMaxSearchTree(int numberOfPossibilities) {
		this.numberOfPossibilities = numberOfPossibilities;
		comparator = new Comp();
		children = new Node[numberOfPossibilities];
	}

	public MiniMaxSearchTree( Comparator<K> comp ) {
		comparator = comp;
	}

	public void setNumberOfPossibilities(int numberOfPossibilities){
		this.numberOfPossibilities = numberOfPossibilities;
	}

	public Node<K, V> root() {
		return tree;
	}

	/*
    public V get(K key) {
        Node<K, V> node = find( key );
        if(node!=null)
            return node.value;
        return null;
    }
	 */
	/*
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
	 */

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

	public Iterator<V> iterator() {
		return new Iter();
	}
	
	/*
    public List<K> keys(){
    	ArrayList<K> list = new List<K>();
    	keys(tree, list);
        return list;
    }*/

	private void keys(Node<K, V> node, ArrayList<K> list){

	}

	private class Comp implements Comparator<K> {
		public int compare( K key1, K key2 ) {
			Comparable<K> k1 = ( Comparable<K> )key1;
			return k1.compareTo( key2 );
		}
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

	public static void main(String[] args) {
		int numberOfPossibilities = 5;
		MiniMaxSearchTree<Integer, GameState> mmst = new MiniMaxSearchTree<Integer, GameState>(numberOfPossibilities);
		GameState gs = new GameState();
		GameEngine ge = new GameEngine();
		Node nRoot = new Node(0, gs, new Node[numberOfPossibilities]);
		
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
		
		
		mmst.add(0, gs);
		System.exit(0);
		int row = 0, column = 0;
		gs = mmst.newMove(ge, row, column);
		mmst.add(0, gs);

		row = 0; column = 1;
		gs = mmst.newMove(ge, row, column);
		//mmst.add(0, gs);

		row = 0; column = 2;
		gs = mmst.newMove(ge, row, column);
		//mmst.add(0, gs);

		row = 0; column = 3;
		gs = mmst.newMove(ge, row, column);
		//mmst.add(0, gs);
	}

	public GameState newMove(GameEngine ge, int row, int column){
		ge.placeDisk(row, column);
		return ge.copyGameState();
	}


	public void debug(String debugLocation, String debugMessage){
		System.out.println(debugLocation + ": " + debugMessage);
	}
}


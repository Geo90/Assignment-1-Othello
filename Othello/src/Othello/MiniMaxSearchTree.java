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

	private int key = 0;
	private Comparator<K> comparator;
	private Node<K, V> tree;
	private Node<K, V>[] children;
	private int depth = 3;

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

	public void add(K key, V value, int depth) {
		tree = add(tree, key, value, depth);        
	} 

	private Node<K, V> add(Node<K, V> node, K key, V value, int depth) {
		int index = 0;
		debugLocation = "MiniMaxSearchTree, add((Node<K, V> node...): ";
		for(int i = 0; i<node.children.length; i++){
			if( node.children[i] == null && depth< this.depth-1) {
				node.children[i] = new Node<K, V>(key, value, new Node[numberOfPossibilities]);
				debug(debugLocation + "node.children["+i+"]: " , node.children[i].toString());
				index = i;
				break;
			} 
			else{
				if(i == 0)
					debug(debugLocation, "The bottom of tree is reached! No more child-nodes! \nnode.children[i]: ");
				debug(i+"" , "This child-node is null");
				
			}
		}
		return node;
	}

	//empty method
	private void keys(Node<K, V> node, ArrayList<K> list){}
	

	public static void main(String[] args) {
		/*
		 * ***********************************
		 * 		Initilalizing instances
		 * ***********************************
		 */
		int numberOfChildren = 5;
		MiniMaxSearchTree<Integer, GameState> mmst = new MiniMaxSearchTree<Integer, GameState>(numberOfChildren);
		GameEngine gEngine = new GameEngine();
		GameState gState = gEngine.copyGameState();
		
		mmst.tree = new Node(mmst.key, gState, new Node[numberOfChildren]);
		
		mmst.printRoot(mmst.tree);
		
		
		GameState gsValue = (GameState)mmst.tree.value;
		mmst.debugMessage = mmst.debugMessage = "gsValue.getPlayerTurn(): " + gsValue.getPlayerTurn();;
		mmst.debug(mmst.debugLocation, mmst.debugMessage);
		
		
		for(int i = 0; i<mmst.depth; i++){
			System.out.println("--- DEPTH --- : " + i);
			MiniMaxAgent mmAgent = new MiniMaxAgent(gEngine);
			int square = mmAgent.agentMove();
			gState = mmst.newMove(gEngine, square);
			mmst.add(mmst.key, gState, i);
			mmst.key++;
			
		}
		mmst.debugMessage = "tree.children[0].value:" + mmst.tree.children[0].value;
		mmst.debug(mmst.debugLocation, mmst.debugMessage);
		

		mmst.debugMessage = "tree.children[1].value:" + mmst.tree.children[1].value;
		mmst.debug(mmst.debugLocation, mmst.debugMessage);
		//mmst.printRoot(mmst.tree);
		
	}

	public GameState newMove(GameEngine gEngine, int square){
		int[] rc = gEngine.getRowColumn(square);
		gEngine.placeDisk(rc[0], rc[1]);
		return gEngine.copyGameState();
	}

	public void debug(String debugLocation, String debugMessage){
		System.out.println(debugLocation + ": " + debugMessage);
	}
	
	public void printRoot(Node<K,V> nRoot){
		String debugLocation = this.debugLocation = "MiniMaxSearchTree, printRoot(nRoot) ";
		String debugMessage = this.debugMessage = "nRoot number of children: " + nRoot.children.length;
		debug(debugLocation, debugMessage);
		debugLocation = this.debugLocation = "";
		debugMessage = this.debugMessage = "nRoot.key: " + nRoot.key;
		debug(debugLocation, debugMessage);
		
		debugMessage = this.debugMessage = "nRoot.value: \n" + nRoot.value;
		debug(debugLocation, debugMessage);
		debugMessage = this.debugMessage = "end of method printRoot(nRoot)";
		debug(debugLocation, debugMessage);
		
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
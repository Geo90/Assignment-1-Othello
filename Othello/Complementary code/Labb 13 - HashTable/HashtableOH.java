package laboration13;
import java.util.Iterator;
import f13.Map;
import collections.LinkedList;
import collections.ArrayList;

/**
 * Hashtabellen använder öppen hashing
 * @author Rolf Axelsson
 */
public class HashtableOH<K,V> implements Map<K,V> { 
    private LinkedList<Entry<K,V>>[] table;
    private int size;
    
    /** Creates a new instance of HashtableOH */
    public HashtableOH( int size ) {
        table = (LinkedList<Entry<K,V>>[])new LinkedList[ size ];
        for( int i = 0; i < size; i++ ) {
            table[ i ] = new LinkedList<Entry<K,V>>();
        }
    }
    
    private int hashIndex( K key ) {
        int hashCode = key.hashCode();
        hashCode = hashCode % table.length;
        return ( hashCode < 0 ) ? -hashCode : hashCode;
    }
    
    public V put( K key, V value ) {
    	V res = null;
        int hashIndex = hashIndex( key );
        Entry<K,V> entry = new Entry<K,V>( key, value );
        int index = table[ hashIndex ].indexOf( entry );
        if( index == -1 ) {
            table[ hashIndex ].addFirst( entry );
            size++;
        }
        else {
        	res = table[ hashIndex ].set( index, entry ).value;
        }
        return res;
    }
    
    public void list() {
        Entry<K,V> entry;
        for(int i=0; i<table.length; i++) {
            System.out.print( i + ":");
            for( int j = 0; j < table[ i ].size(); j++ ) {
                entry = table[ i ].get( j );
                System.out.print(" <" + entry.key +"," + entry.value + ">" );
            }
            System.out.println();
        }
    }

	public V get(K key) {
		return null;
	}

	public V remove(K key) {
		return null;
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return false;
	}

	public boolean containsKey(K key) {
		return false;
	}

	public void clear() {
	}

	public Iterator<K> keys() {
		return null;
	}

	public Iterator<V> values() {
        return null;
	}
    
    public static void main(String[] args) {
        HashtableOH<String,String> table = new HashtableOH<String,String>(4);
        table.put("hej", "hello");      
        table.put("röd", "red");        
        table.put("vit", "white");      
        table.put("säng", "bed");       
        table.put("svart", "black");    
        table.put("gul", "yellow");     
        table.put("dator", "computer"); 
        table.put("snö", "snow");       
        table.put("blå", "blue");       
        table.put("grön", "green");     
        table.put("hus", "house");      
        table.list();
    }
}

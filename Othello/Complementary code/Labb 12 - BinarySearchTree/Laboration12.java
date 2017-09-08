package laboration12;
import java.util.*;

import javax.swing.JOptionPane;

public class Laboration12 {
    public void exercise1() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(50), new Integer(50) );
        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(20), new Integer(20) );
        bst.put( new Integer(40), new Integer(40) );
        bst.put( new Integer(60), new Integer(60) );
        bst.put( new Integer(80), new Integer(80) );
        bst.put( new Integer(75), new Integer(75) );
        
        bst.root().print();
        bst.root().showTree();

    }
    
    public void exercise2() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(20), new Integer(20) );
        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(40), new Integer(40) );
        bst.put( new Integer(50), new Integer(50) );
        bst.put( new Integer(60), new Integer(60) );
 
        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(75), new Integer(75) );
        bst.put( new Integer(80), new Integer(80) );
        
        bst.root().print();
        bst.root().showTree();
   }
    
    public void exercise3() {
        BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
        bst.put( new Integer(40), new Integer(40) );
        
        bst.put( new Integer(71), new Integer(71) );
        bst.put( new Integer(75), new Integer(75) );
        bst.put( new Integer(80), new Integer(80) );

        bst.put( new Integer(70), new Integer(70) );
        bst.put( new Integer(60), new Integer(60) );
        
        bst.put( new Integer(50), new Integer(50) );

        bst.put( new Integer(30), new Integer(30) );
        bst.put( new Integer(20), new Integer(20) );
        
        bst.root().print();
        bst.root().showTree();
    }
    
    public void exercise4() {
    	   BinarySearchTree<Integer,Integer> bst = new BinarySearchTree<Integer,Integer>();
           bst.put( new Integer(27), new Integer(27) );
           
           bst.put( new Integer(15), new Integer(15) );
           bst.put( new Integer(38), new Integer(38) );
         

           bst.put( new Integer(45), new Integer(45) ); 
           bst.put( new Integer(44), new Integer(44) );
           bst.put( new Integer(36), new Integer(36) );
           
           bst.put( new Integer(17), new Integer(17) );
           
           bst.root().print();
           bst.root().showTree();
    }
    
    public void exercise5() {
    	  BinarySearchTree<String,String> bst = new BinarySearchTree<String,String>();
          
          bst.put( new String("F"), new String("F") );
                  
          bst.put( new String("B"), new String("B") );
                  
          bst.put( new String("I"), new String("I") ); 
        
          bst.put( new String("C"), new String("C") );
          bst.put( new String("D"), new String("D") );
          bst.put( new String("H"), new String("H") );
          bst.put( new String("G"), new String("G") );
          

        
          
          bst.root().print();
          bst.root().showTree();
    }
    
    /*********************** Uppgift 6 *************************/
    private BinarySearchTree<String,String> svenskEngelsk() {
        BinarySearchTree<String,String> tree = new BinarySearchTree<String,String>();
        tree.put("vacker","beautiful");
        tree.put("svart","black");
        tree.put("boll", "ball");
        tree.put("vit","white");
        tree.put("lärare","teacher");
        tree.put("karta","map");
        tree.put("hus","house");
        tree.put("vänster","left");
        tree.put("höger","right");
        return tree;
    }
    
    public void exercise6() {
        BinarySearchTree<String,String> tree = svenskEngelsk();
        String svenska = javax.swing.JOptionPane.showInputDialog( "Skriv ett svenskt ord" ), engelska;
        while( svenska!=null && !svenska.equals("slut") ) {
        	
            // hämta värdet för det inmatade ordet ur trädet
        	engelska = tree.get(svenska);
            // visa resultatet i en dialog
            JOptionPane.showMessageDialog(null, svenska + " ger resultatet " + engelska);
        	// låt användaren mata in ett nytt ord
            svenska = javax.swing.JOptionPane.showInputDialog( "Skriv ett svenskt ord" );
           
        }
    }
    
    /*********************** Uppgift 7 *************************/
    private TreeMap<String,String> capitals() {
        TreeMap<String,String> tree = new TreeMap<String,String>();
             // Skriv ca 10 rader med kod vilka lägger till par av typen ( land, huvudstad )
        tree.put("Sverige","Stockholm");
        tree.put("Tyskland","Berlin");
        tree.put("England","London");
        tree.put("Frankrike","Paris");
        tree.put("Rum�nien","Bukarest");
        tree.put("Serbien","Belgrad");
        tree.put("Bosnien","Sarajevo");
        tree.put("USA","Washington DC");
        tree.put("Danmark","K�penhamn");
        
        return tree;
    }
    
    public void exercise7() {
        // Komplettera med kod
    }
    
    /*********************** Uppgift 11a + 11b *************************/
    private <K,V> AVLNode<K,V> rotateRight(AVLNode<K,V> node) {
        return node;
    }
    
    private <K,V> AVLNode<K,V> rotateLeft(AVLNode<K,V> node) {
        return node;
    }
    
    public void exercise11a() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n5, null );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), n4, n3 );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), n2, n1 );
        root.showAVL();
        root = rotateRight(root);
        root.showAVL();
    }
    
    public void exercise11b() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), null, n5 );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), n3, n4 );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n2, n1 );
        root.showAVL();
        root = rotateLeft(root);
        root.showAVL();
    }
    
    /*********************** Uppgift 12a + 12b + 12c *************************/
    private <K,V> int height(AVLNode<K,V> node ) {
        if( node == null )
            return -1;
        return 1 + Math.max( height( node.left ), height( node.right ));
    }
    
    private <K,V> AVLNode<K,V> balanceLeft(AVLNode<K,V> node) {
        return node;
    }
    
    private <K,V> AVLNode<K,V> balanceRight(AVLNode<K,V> node) {
        return node;
    }

    public void exercise12a() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n5, null );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), n4, n3 );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), n2, n1 );
        root.showAVL();
        root = balanceLeft(root);
        root.showAVL();
        AVLNode<Integer,Integer> n6 = new AVL	Node<Integer,Integer>( new Integer(2), new Integer(2), null, null );
        n5.right = n6;
        root.showAVL();
        root.left = balanceLeft(root.left);
        root.showAVL();
    }

    public void exercise12b() {
        AVLNode<Integer,Integer> n5 = new AVLNode<Integer,Integer>( new Integer(15), new Integer(15), null, null );
        AVLNode<Integer,Integer> n4 = new AVLNode<Integer,Integer>( new Integer(13), new Integer(13), null, n5 );
        AVLNode<Integer,Integer> n3 = new AVLNode<Integer,Integer>( new Integer(5), new Integer(5), null, null );
        AVLNode<Integer,Integer> n2 = new AVLNode<Integer,Integer>( new Integer(1), new Integer(1), null, null );
        AVLNode<Integer,Integer> n1 = new AVLNode<Integer,Integer>( new Integer(10), new Integer(10), n3, n4 );
        AVLNode<Integer,Integer> root = new AVLNode<Integer,Integer>( new Integer(3), new Integer(3), n2, n1 );
        root.showAVL();
        root = balanceRight(root);
        root.showAVL();
        AVLNode<Integer,Integer> n6 = new AVLNode<Integer,Integer>( new Integer(14), new Integer(14), null, null );
        n5.left = n6;
        root.showAVL();
        root.right = balanceRight(root.right);
        root.showAVL();
    }
    
    
    public static void main(String[] args) {
        Laboration12 lab12 = new Laboration12();
        lab12.exercise6();
    }
}

package laboration13;
import java.util.*;

public class HashExample {
    
    public static void example1() {
        HashMap<String,Integer> table = new HashMap<String,Integer>(100);
        Random rand = new Random();
        int random;
        for( int i=5; i<15; i++) {
            random = rand.nextInt(1000000);
            table.put(String.valueOf(i), new Integer(random));
        }
        System.out.println("containsKey - table innehåller nyckeln 16: " + table.containsKey("16"));
        System.out.println("containsValue - table innehåller värdet 827763: " + table.containsValue(new Integer(827763)));
        System.out.println("Värde till nyckeln 29: " + table.get("29"));
        System.out.println("Värde till nyckeln 9: " + table.get("9"));
        System.out.println("Borttagning av element med nyckel 29: " + table.remove("29"));
        System.out.println("Borttagning av element med nyckel 9: " + table.remove("9"));
        System.out.println("Antal element i Hashtabell: " + table.size());
        System.out.println("Det är inga element i Hashtabellen: " + table.isEmpty());
        
        // Utskrift av alla <key,value> par
        Set<String> keys = table.keySet();
        Iterator<String> iter = keys.iterator();
        String key;
        Integer value;
        while(iter.hasNext()) {
            key = (String)iter.next();
            value = table.get(key);
            System.out.println( String.format("%3s: %d",key,value));
        }
        
        table.clear();
        System.out.println("Antal element i Hashtabell: " + table.size());
    }
    
    public static void main(String[] args) {
        HashExample.example1();
    }
}

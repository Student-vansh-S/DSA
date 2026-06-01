import java.util.*;

public class HashingTechniques {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        LinkedHashMap<Integer,Integer> lhm = new LinkedHashMap<>();
        TreeMap<String,Integer> tm = new TreeMap<>();
        
        HashSet<Integer> hs = new HashSet<>();
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        TreeSet<String> ts = new TreeSet<>();

        //  HashMap Implementation
        map.put("Delhi", 10);
        map.put("Mumbai", 15);
        map.put("Pune", 40);
        map.put("UP", 50);
        map.put("Delhi", 25);

        for(String key : map.keySet()){
            System.out.println(key+" -> "+map.get(key));
        }

        // LinkedHashMap Implementation
        lhm.put(1, 10);
        lhm.put(2, 20);
        lhm.put(3, 30);
        lhm.put(4, 40);
        lhm.put(3, 60);

        for(Integer key : lhm.keySet()){
            System.out.println(key+" -> "+lhm.get(key));
        }

        // TreeMap Implementation
        tm.put("India", 150);
        tm.put("China", 100);
        tm.put("Nepal", 50);
        tm.put("USA", 90);
        tm.put("China", 140);
        
        for(String key : tm.keySet()){
            System.out.println(key+" -> "+tm.get(key));
        }

        // HashSet Implementation
        hs.add(10);
        hs.add(100);
        hs.add(40);
        hs.add(78);
        hs.add(50);
        hs.add(10);

        // Iteration on HashSet using Iterator

        Iterator<Integer> it = hs.iterator(); // Both are correct 
        // Iterator it = hs.iterator();  Both are correct 
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Iteration on HashSet using for each loop

        for(Integer i : hs){
            System.out.println(i);
        }

        // LinkedHashSet Implementation
        lhs.add("Rajisthan");
        lhs.add("Delhi");
        lhs.add("Pune");
        lhs.add("Mumbai");
        lhs.add("UP");
        
        for(String i:lhs){
            System.out.println(i);
        }

        // TreeSet Implementation
        ts.add("Rajisthan");
        ts.add("Delhi");
        ts.add("Pune");
        ts.add("Mumbai");
        ts.add("UP");

        for(String i:ts){
            System.out.println(i);
        }
    }    
}

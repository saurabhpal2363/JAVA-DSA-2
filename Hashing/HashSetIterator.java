package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetIterator {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(4);
        set.add(1);

        // Method 1. By iterator 
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // Method 2. By Advanced loop 
        for(Integer i : set) {
            System.out.println(i);
        }
    }
}

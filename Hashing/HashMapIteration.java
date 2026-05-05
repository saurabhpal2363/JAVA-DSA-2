package Hashing;

import java.util.*;

public class HashMapIteration {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 150);
        map.put("China", 100);
        map.put("US", 50);
        map.put("Indonesia", 6);
        map.put("Nepal", 5);

        Set<String> keys = map.keySet();
        System.out.println(keys);

        for(String k : keys) {
            System.out.println("Key = " + k + " , Value = " + map.get(k));
        }
    }
}

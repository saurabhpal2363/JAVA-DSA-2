package Hashing;

import java.util.HashMap;

public class hashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Put
        map.put("India", 100);
        map.put("Bhutan", 50);

        System.out.println(map);

        // Contains key
        System.out.println(map.containsKey("US"));

        // Get 
        System.out.println(map.get("US"));

        // Remove 
        System.out.println(map.remove("India"));

        // Size 
        System.out.println(map.size());

        // isEmpty 
        System.out.println(map.isEmpty());

        // Clear -- Entire data are delete
        map.clear();
        System.out.println(map.isEmpty());
    }
}

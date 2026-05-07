package Hashing;

// print in order of put order -- by doubly LL
import java.util.LinkedHashMap;

public class linkedHashMap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 150);
        lhm.put("US", 120);
        lhm.put("China", 56);

        System.out.println(lhm);
    }
}

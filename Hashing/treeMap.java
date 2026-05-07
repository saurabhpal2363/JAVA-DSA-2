package Hashing;

// Keys are sorted -- print in order of sorted -- BY RED-BLACK TREE
// put, get, remove -- O(logn)
import java.util.TreeMap;

public class treeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();

        tm.put("India", 150);
        tm.put("US", 120);
        tm.put("China", 56);

        System.out.println(tm);
    }
}

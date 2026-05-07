package Hashing;

import java.util.HashSet;

public class hashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(4);
        set.add(1);
        set.add(null);

        System.out.println(set);
        set.clear();
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}

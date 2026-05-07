package Hashing;

import java.util.LinkedHashSet;

public class linkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Etawah");
        lhs.add("Mumbai");
        lhs.add("Kolkata");

        System.out.println(lhs);

        lhs.remove("Delhi");
        System.out.println(lhs);
    }
}

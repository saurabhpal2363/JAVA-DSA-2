package deque;

import java.util.Deque;
import java.util.LinkedList;

public class Deque1 {
    public static void main(String[] args) {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        System.out.println(d);
    }
}
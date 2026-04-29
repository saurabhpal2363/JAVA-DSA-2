package PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class pq {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // For ASC
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());  // For DESC
        pq.add(5);
        pq.add(3);
        pq.add(1);
        pq.add(2);

        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}

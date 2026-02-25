package Queue;

import java.util.LinkedList;
import java.util.*;

public class ByCollections {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();    // Or we can write ArrayDeque
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

package LinkedList;
import java.util.LinkedList;

public class LinkedList2 {
    public static void main(String[] args) {
        // Create - object
        LinkedList<Integer> ll = new LinkedList<>();

        // Add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);

        System.out.println(ll.size());

        // Remove
        ll.removeLast();
        ll.removeFirst();

        System.out.println(ll);
    }
}

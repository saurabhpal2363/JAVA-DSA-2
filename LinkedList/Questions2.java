package LinkedList;

public class Questions2 {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {  // O(1)
        // Step1. create newNode 
        Node newNode = new Node(data);
        size++;

        if(head == null) {
            head = tail = newNode;
            return;
        }

        // Step2. newNode next = head 
        newNode.next = head;

        // Step3. head = newNode 
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;

        Node temp = head;
        int i = 0;
        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;

        head = head.next;
        size--;

        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    public void printList() {  // O(n)
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        
        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // Floyd's Cycle finding Algorithm.
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void removeCycle() {
        // Detect Cycle 
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                cycle = true;
                break;
            }
        }

        if(cycle == false) {
            return;
        }

        // Find meeting Point.
        slow = head;
        Node prev = null;
        
        while(slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Remove cycle -> last.next = null 
        prev.next = null;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;  // mid
    }

    private Node merge(Node head1, Node head2) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public Node mergeSort(Node head) {    // O(nlogn)
        if(head == null || head.next == null) {
            return head;
        }

        // Find mid 
        Node mid = getMid(head);

        // Left and right MergeSort 
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge 
        return merge(newLeft, newRight);
    }

    public void zigzag() {
        // Find mid
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // Reverse 2nd Half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // Alt merge - zig-zag merge 
        while(left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR; 
        }
    }

    public static void main(String[] args) {
        // head = new Node(1);
        // head.next = new Node(2);
        // head.next.next = new Node(3);
        // head.next.next.next = new Node(5);
        // head.next.next.next.next = head.next;

        Questions2 ll = new Questions2();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        
        // ll.printList();
        // ll.head = ll.mergeSort(ll.head);
        ll.printList();

        ll.zigzag();
        ll.printList();

    }
}

public class Solution {
    public static class Node {
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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
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

        int i=0;
        while(i != idx-1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;

        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MAX_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node prev = head;
        
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }

        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    public static int iterSearch(int val) {
        if(size == 0) {
            return -1;
        } 

        Node temp = head;
        int idx = 1;

        while(temp != null) {
            if(temp.data == val) {
                return idx;
            }

            temp = temp.next;
            idx++;
        }

        return -1;
    }

    public int helper(int key, Node temp) {
        if(temp == null) {
            return -1;
        }

        if(temp.data == key) {
            return 0;
        }

        int res = helper(key, temp.next);

        if(res == -1) {
            return res;
        } else {
            return res+1;
        }
    }

    public int recSearch(int key) {
        return helper(key, head);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void rmvFrLst(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(sz == n) {
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz-n;
        Node prev = head;

        while(iToFind > i) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
    }

    public void print() {
        if(head == null) {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");

    }

    // Slow-Fast Technique 
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean isPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }

        Node midNode = findMid(head);
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev;
        Node left = head;

        while(right != null) {
            if(right.data != left.data) {
                return false;
            }

            right = right.next;
            left = left.next;
        }

        return true;
    }

    public boolean isCycle() {
        if(head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                return true;
            }
        }

        return false;
    }

    public void remCycle() {
        Node slow = head;
        Node fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                isCycle = true;
                break;
            }
        }

        if(isCycle) {
            slow = head;
            Node prev = null;
            while(slow != fast) {
                slow = slow.next;
                prev = fast;
                fast = fast.next;
            }

            prev.next = null;
        }
        
    }

    public static void main(String[] args) {
        Solution ll = new Solution();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);

        ll.print();

        // ll.reverse();
        // ll.print();

        System.out.println(ll.isPalindrome());
    }
}
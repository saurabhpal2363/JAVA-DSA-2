package deque;

import java.util.*;

public class Questions {
    
    // Ques. Stack and Queue using Deque 
    static class Stack {
        Deque<Integer> d = new LinkedList<>();

        public void push(int data) {
            d.addLast(data);
        }

        public int pop() {
            return d.removeLast();
        }

        public int peek() {
            return d.getLast();
        }
    }

    static class Queue {
        Deque<Integer> d = new LinkedList<>();

        public void add(int data) {
            d.addLast();
        }

        public int remove() {
            return d.removeFirst();
        }

        public int peek() {
            return d.getFirst();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
    }

}

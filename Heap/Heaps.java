package Heap;

import java.util.*;

public class Heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {     // O(logn)
            // Add at last idx
            arr.add(data);

            int x = arr.size() - 1;     // x is child idx
            int par = (x-1) / 2;    // parent idx
            
            while(arr.get(x) < arr.get(par)) {      // O(logn)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(temp, arr.get(x));
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public int remove() {
            int data = arr.get(0);

            // Step1. Swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // Step2. Delete last
            arr.remove(arr.size() - 1);

            // Step3. Heapify
            
        }
    }

    public static void main(String[] args) {
        
    }
}

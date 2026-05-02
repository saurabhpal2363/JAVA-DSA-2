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
                arr.set(par, temp);

                x = par;
                par = (x-1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {       // O(logn)
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if(minIdx != i) {
                // Swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
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
            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(5);

        while(!pq.isEmpty()) {      // Heap sort  - O(nlogn)
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}

package Hashing;

import java.util.*;

public class setQuestions {
    public static void countUnique(int nums[]) {    // O(n)
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        System.out.println(set.size());
    }

    public static void unionIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union is: " + set.size());

        set.clear();

        int count = 0;
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) {
                set.remove(arr2[i]);
                count++;
            }
        }

        System.out.println("Intersection is: " + count);
    }

    public static void main(String[] args) {
        int nums[] = {4, 3, 2, 5, 6, 7, 3, 4, 2, 1};
        // countUnique(nums);

        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        unionIntersection(arr1, arr2);
    }
}

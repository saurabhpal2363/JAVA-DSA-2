package Hashing;

import java.util.*;

public class mapQuestions {
    public static void majorityElement(int nums[]) {        // O(n)
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            // if(map.containsKey(nums[i])) {
            //     map.put(nums[i], map.get(nums[i])+1);
            // } else {
            //     map.put(nums[i], 1);
            // }

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Integer key : map.keySet()) {
            if(map.get(key) > nums.length/3) {
                System.out.print(key + " ");
            }
        }
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            if(map.get(t.charAt(i)) != null) {
                if(map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        // int nums[] = {1, 2};
        // majorityElement(nums);

        String s = "tulip";
        String t = "lipid";

        System.out.println(isAnagram(s, t));
    }
}

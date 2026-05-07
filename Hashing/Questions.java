package Hashing;

import java.util.*;

public class Questions {
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for(String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }

    public static void itineraryTickets(HashMap<String, String> tickets) {
        String start = getStart(tickets);
        System.out.print(start);

        for(String key : tickets.keySet()) {
            System.out.print(" -> " + tickets.get(start));
            start = tickets.get(start);
        }
    }

    // Ques. Largest subArray with 0 sum 
    public static void largestSubarray(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // (sum, idx) 

        int sum = 0;
        int len = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                len = Math.max(len, i-map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        System.out.println("Largest Subarray with sum: " + len);
    }

    // Ques. Subarray sum equal to k 
    public static void subarraySum(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // (sum, count)

        map.put(0, 1);
    
        int sum = 0;
        int ans = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum-k)) {
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println(ans);
    }
    
    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bengaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        // itineraryTickets(tickets);

        // int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
        // largestSubarray(arr);

        int arr[] = {10, 2, -2, -20, 10};
        int k = -10;
        subarraySum(arr, k);
    }
}

package ArrayList;

import java.util.ArrayList;

public class PairSum2 {
    public static boolean pairSum(ArrayList<Integer> arr, int target) {
        int bp = -1;
        for(int i=0; i<arr.size()-1; i++) {
            if(arr.get(i) > arr.get(i+1)) {
                bp = i;
                break;
            }
        }

        int rp = bp;
        int lp = bp + 1;

        while(rp != lp) {
            if(arr.get(rp) + arr.get(lp) == target) {
                return true;
            }

            if(arr.get(rp) + arr.get(lp) > target) {
                rp = (arr.size() + rp - 1) % arr.size();
            }
            else {
                lp = (lp + 1) % 2;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // sorted and rotated array

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(15);
        arr.add(6);
        arr.add(8);
        arr.add(9);
        arr.add(10);

        System.out.println(pairSum(arr, 16));
    }
}

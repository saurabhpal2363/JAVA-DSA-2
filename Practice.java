import java.util.ArrayList;
import java.util.Collections;

public class Practice {

    public static void findLonely(ArrayList<Integer> arr) {
        Collections.sort(arr);

        ArrayList<Integer> list  = new ArrayList<>();
        for(int i=1; i<arr.size()-1; i++) {
            if(arr.get(i)-1 == arr.get(i-1) || arr.get(i)+1 == arr.get(i+1) || arr.get(i) == arr.get(i-1)) {
                continue;
            } else {
                list.add(arr.get(i));
            }
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(3);

        findLonely(arr);
    }
}
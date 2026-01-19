package Recursion;

public class Occurance {
    public static int firstOccurance(int arr[], int key, int i) {
        if(arr[i] == key) {
            return i;
        }

        if(i == arr.length) {
            return -1;
        }

        return firstOccurance(arr, key, i+1);
    }

    public static int lastOccurance(int arr[], int key, int i) {
        if(i == arr.length) {
            return -1;
        }
        int isFound = lastOccurance(arr, key, i+1);

        if(isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static void main(String[] args) {
        int arr[] = {8, 3, 6, 9, 5, 10, 2, 5, 3};
        System.out.println("Key fount at index " + lastOccurance(arr, 5, 0));
    }
}

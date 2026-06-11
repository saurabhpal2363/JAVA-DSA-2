class Solution {
    public static void decOrd(int n) {
        if(n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        decOrd(n-1);
    }

    public static void incOrd(int n) {
        if(n == 1) {
            System.out.print(n + " ");
            return;
        }
        incOrd(n-1);
        System.out.print(n + " ");
    }

    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }

        int fnm1 = fact(n-1);
        int fn = n * fnm1;

        return fn;
    }

    public static int fibbo(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int fnm1 = fibbo(n-1);
        int fnm2 = fibbo(n-2);

        int fn = fnm1 + fnm2;

        return fn;
    }

    public static void changeArr(int arr[], int i, int v) {
        if(i == arr.length) {
            printArr(arr);
            return;
        }

        arr[i] = v;
        changeArr(arr, i+1, v+1);
        arr[i] = arr[i] - 2;
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }

    public static void main(String []args){
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
    }
}
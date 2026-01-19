package Recursion;

public class Ques {
    public static int tileProblem(int n) {
        if(n==1 || n==0) {
            return 1;
        }

        // vertical
        int fnm1 = tileProblem(n-1);

        // horizontal
        int fnm2 = tileProblem(n-2);

        int total = fnm1 + fnm2;

        return total;
    }

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean arr[]) {
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);

        if(arr[currChar - 'a'] == true) {
            removeDuplicates(str, idx+1, newStr, arr);
        }
        else {
            arr[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(str.charAt(idx)), arr);
        }
    }

    public static int friendsPairing(int n) {
        if(n == 1 || n == 2) {
            return n;
        }

        // single
        int fnm1 = friendsPairing(n-1);

        // pairing
        int fnm2 = friendsPairing(n-2);
        int pair = (n-1) * fnm2;

        int totalWays = fnm1 + pair;

        return totalWays;
    }

    public static void printBinaryString(int n, int lastPlace, String newStr) {

        if(n == 0) {
            System.out.println(newStr);
            return;
        }

        printBinaryString(n-1, 0, newStr + "0");
        if(lastPlace == 0) {
            printBinaryString(n-1, 1, newStr + "1");
        }
    }

    public static void main(String args[]) {
        // System.out.println(tileProblem(5));

        // String str = "appnnacollege";
        // removeDuplicates(str, 0, new StringBuilder(""), new boolean[26]);

        // System.out.println(friendsPairing(3));

        printBinaryString(3, 0, "");
    }
}

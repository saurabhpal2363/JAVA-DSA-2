package Backtracking;

public class Ques {
    public static void subString(String str, String ans, int i) {   // O(2^n * n)
        if(i == str.length()) {
            System.out.println(ans);
            return;
        }

        // if YES 
        subString(str, ans+str.charAt(i), i+1);

        // if NO 
        subString(str, ans, i+1);
    }

    public static void findPermutation(String str, String ans) {    // O(n! * n)
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char curr = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            findPermutation(newStr, ans+curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        // subString(str, "", 0);

        findPermutation(str, "");
    }
}

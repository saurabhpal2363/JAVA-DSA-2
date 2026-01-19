package Recursion;

public class Power {  
    public static int power(int x, int n) {
        if(n == 0) {
            return 1;
        } 

        return x * power(x, n-1);
    }

    public static int optimizedPower(int x, int n) {  // O(logn)
        if(n == 0) {
            return 1;
        }

        int halfPow = optimizedPower(x, n/2);
        int halfPowSqr = halfPow * halfPow;

        if(n % 2 != 0) {
            halfPowSqr = x * halfPowSqr;
        }

        return halfPowSqr;
    }

    public static void main(String[] args) {
        System.out.println(optimizedPower(2, 5));
    }
}

import java.util.*;

public class Basic {
    
    public static boolean isPrime(int n) {
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void primeInRange(int num) {
        for(int i=2; i<=num; i++) {
            if(isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String args[]) {
        int num = 20;
        primeInRange(num);
    }
}
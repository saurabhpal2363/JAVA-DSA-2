import java.util.*;

public class Conversion {

    public static void decimalToBinary(int number) {
        int pow = 0;
        int calc = 0;
        while(number != 0) {
            int lastDigit = number % 10;
            calc += lastDigit * Math.pow(2, pow);
            pow++;
            number /= 10;
        }

        System.out.println(calc);
    }

    public static void BinaryToDecimal(int number) {
        int pow = 0;
        int calc = 0;
        while(number != 0) {
            int rem = number % 2;
            calc += rem * Math.pow(10, pow);
            pow++;
            number /= 10;
        }

        System.out.println(calc);
    }
    public static void main(String[] args) {
        int number = 111;
        BinaryToDecimal(number);
    }
}

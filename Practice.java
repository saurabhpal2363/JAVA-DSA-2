import java.util.Scanner;

public class Practice {
    public static String grade(int marks) {
        if(marks>=0 && marks<=34)
            return "fail";
        else if(marks>=35 && marks<=49)
            return "third class";
        else if(marks>=50 && marks<=59)
            return "second class";
        else if(marks>=60 && marks<=74)
            return "first class";
        else if(marks>=75 && marks<=100)
            return "distinction";
        else
            return "INVALID";
    }
    public static void main(String[] args) {
        System.out.println(grade(54));
        System.out.println(grade(91));
        System.out.println(grade(154));
    }
}
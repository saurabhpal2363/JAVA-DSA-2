import java.util.*;

class Solution {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        int a, b, n;
        for(int i=0;i<t;i++){
            a = in.nextInt();
            b = in.nextInt();
            n = in.nextInt();

            for(int j=1; j<n; j++) {
            System.out.print(a + (int)Math.pow(2, i) * b);
            System.out.print(" ");
        }
        }
        in.close();
    }
}
public class Practice {
    public static void main(String[] args) {
        int n = 5;
        int f1 = 0;
        int f2 = 1;
        int f = f1 + f2;

        System.out.print(f1 + " ");
        System.out.print(f2 + " ");

        while(f<=n) {
            System.out.print(f + " ");
            f1 = f2;
            f2 = f;
            f = f1 + f2;
        }
    }
}
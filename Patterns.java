public class Patterns {

    public static void hollow_rectangle(int rows, int cols) {
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                if(i==1 || i==rows || j==1 || j==cols) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void inverted_Half_Pyramid(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=n-i; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Half_Pyramid_Number(int n) {
        for(int i=1; i<=n; i++) {
            int num = 1;
            for(int j=i; j<=n; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    public static void floydTriangle(int n) {
        int num = 1;

        for(int i=0; i<=n; i++) {
            for(int j=0; j<=i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    public static void triangle(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                if((i+j) % 2 ==0) {
                    System.out.print("1" + " ");
                }
                else {
                    System.out.print("0" + " ");
                }
            }
            System.out.println();
        }
    }

    public static void butterfly(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                System.out.print("*" + " ");
            }

            for(int k=1; k<=2*(n-i); k++) {
                System.out.print(" " + " ");
            }

            for(int l=1; l<=i; l++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                System.out.print("*" + " ");
            }

            for(int k=1; k<=2*(n-i); k++) {
                System.out.print(" " + " ");
            }

            for(int l=1; l<=i; l++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    public static void solid_rhombus(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=n; j>i; j--) {
                System.out.print(" " + " ");
            }

            for(int k=1; k<=n; k++) {
                System.out.print("*" + " ");
            }

            System.out.println();
        }
    }

    public static void hollow_rhombus(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=n; j>i; j--) {
                System.out.print(" " + " ");
            }

            for(int k=1; k<=n; k++) {
                if(i==1 || i==n || k==1 || k==n) {
                    System.out.print("*" + " ");
                }
                else {
                    System.out.print(" " + " ");
                }
            }

            System.out.println();
        }
    }

    public static void diamond(int n) {
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" " + " ");
            }

            for(int k=1; k<=2*i-1; k++) {
                System.out.print("*" + " ");
            }

            System.out.println();
        }

        for(int i=n; i>=1; i--) {
            for(int j=1; j<=n-i; j++) {
                System.out.print(" " + " ");
            }

            for(int k=1; k<=2*i-1; k++) {
                System.out.print("*" + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        diamond(5);
    }
}

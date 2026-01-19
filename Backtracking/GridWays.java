package Backtracking;

public class GridWays {
    public static int gridWays(int i, int j, int m, int n) { // O(2^(n+m))
        if(i == m-1 || j == n-1) { // condition for last cell
            return 1;
        }
        else if(i == m || j == n) { // condition for boundary crossing
            return 0;
        }

        int w1 = gridWays(i+1, j, m, n);
        int w2 = gridWays(i, j+1, m, n);

        return w1 + w2;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        System.out.println(gridWays(0, 0, m, n));
    }
}

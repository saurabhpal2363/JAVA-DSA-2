package Strings;

public class ShortestPath {
    public static float getShortestPath(String str) {
        int x = 0;
        int y = 0;

        for(int i=0; i<str.length(); i++) {
            char dir = str.charAt(i);

            if(dir == 'W') {
                x--;
            }

            if(dir == 'E') {
                x++;
            }

            if(dir == 'N') {
                y++;
            }

            if(dir == 'S') {
                y--;
            }
        }

        int X2 = x * x;
        int Y2 = y * y;

        return (float)Math.sqrt(X2 + Y2); 
    }

    public static void main(String[] args) {
        String str = "WNEENESENNN";
        System.out.println(getShortestPath(str));
    }
}

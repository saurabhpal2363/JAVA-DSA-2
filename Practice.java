class Square {
    int length;
    void area() {
        int area = length*length;
        System.out.println(area);
    }
}

public class Practice {
    public static void main(String[] args) {
        Square sq = new Square();
        sq.length = 5;
        sq.area();
    }
}
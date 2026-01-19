public class Matrices {
    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while(startRow <= endRow && startCol <= endCol) {
            // top
            for(int j=startCol; j<=endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right 
            for(int i=startRow+1; i<=endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }

            // bottom 
            for(int j=endCol-1; j>=startCol; j--) {
                if(startRow == endRow) {
                    break;
                }
                
                System.out.print(matrix[endRow][j] + " ");
            }

            // left
            for(int i=endRow-1; i>=startRow+1; i--) {
                if(startCol == endCol) {
                    break;
                }

                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        for(int i=0; i<matrix.length; i++) {
            // for(int j=0; j<matrix[0].length; j++) {
            //     if(i == j) {
            //         sum += matrix[i][j];
            //     }

            //     if(i + j == matrix.length-1) {
            //         sum += matrix[i][j];
            //     }
            // }

            // Primary Diagonal 
            sum += matrix[i][i];

            // Secondary Diagonal 
            if(i != matrix.length-i-1) {
                sum += matrix[i][matrix.length-i-1];
            }

        }

        return sum;
    }

    public static boolean staircaseSearch(int matrix[][], int key) {
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == key) {
                System.out.println("Key found at index (" + row + "," + col + ")");
                return true;
            }
            else if(key < matrix[row][col]) {
                col--;
            }
            else {
                row++;
            }
        }

        System.out.println("Key Not Found");
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int key = 33;

        // printSpiral(matrix);
        // System.out.println(diagonalSum(matrix));
        staircaseSearch(matrix, key);
    }
}

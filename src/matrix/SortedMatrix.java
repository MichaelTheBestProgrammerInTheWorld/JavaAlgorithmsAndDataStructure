package matrix;

public class SortedMatrix {

    //Search in a row and column wise sorted matrix
    public void search(int[][] matrix, int length, int key){
        int smallest = matrix[0][0];
        int biggest = matrix[length-1][length-1];
        if (key < smallest || key > biggest){
            System.out.println(key + " not found in matrix");
            return;
        }
        int i = 0;
        int j = length-1;
        while (i < length && j >= 0){
            if (matrix[i][j] == key){
                System.out.println(key + " found at index " + i + " , " + j);
                return;
            }
            if (matrix[i][j] > key){
                j--;
            } else {
                i++;
            }
        }
        System.out.println(key + " not found in matrix");
    }

    //Print a given matrix in Spiral form
    public void spiralPrint(int[][] matrix, int r, int c) {
        int i;
        int k = 0; // k -> r
        int l = 0; // l -> c

        while (k < r && l < c) {
            // left to right --> column varies --> l -> c - 1, row remains constant
            for (i = l; i < c; i++) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;
            // top to bottom --> row varies --> k -> r - 1, column remains constant
            for (i = k; i < r; i++) {
                System.out.print(matrix[i][c - 1] + " ");
            }
            c--;
            if (k < r) {
                // right to left --> column varies --> c - 1 -> l, row remains constant
                for (i = c - 1; i >= l; i--) {
                    System.out.print(matrix[r - 1][i] + " ");
                }
                r--;
            }
            if (l < c) {
                // bottom to top --> row varies --> r - 1 -> k, column remains constant
                for (i = r - 1; i >= k; i--) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 51}
        };

        SortedMatrix sm = new SortedMatrix();
        sm.search(matrix, 4, 32);
        sm.search(matrix, 4, 35);
        sm.search(matrix, 4, 15);
        sm.search(matrix, 4, 51);
        sm.search(matrix, 4, 10);
        sm.search(matrix, 4, 5);
        sm.search(matrix, 4, 55);
        sm.search(matrix, 4, 28);

        sm.spiralPrint(matrix, 4, 4);
    }
}

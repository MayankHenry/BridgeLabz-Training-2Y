import java.util.Scanner;

class Copy2DTo1D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = input.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        int[] singleDimArray = new int[rows * cols];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                singleDimArray[index] = matrix[i][j];
                index++;
            }
        }

        System.out.print("\nThe 1D array is: ");
        for (int element : singleDimArray) {
            System.out.print(element + " ");
        }
        System.out.println();
        input.close();
    }
}
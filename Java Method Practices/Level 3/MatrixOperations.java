
public class MatrixOperations {

    public static int[][] createRandomMatrix(int rows, int cols) { /* ... same as before ... */ return null; }
    public static void displayMatrix(int[][] matrix) { /* ... same as before ... */ }
    public static double[][] displayMatrix(double[][] matrix) { /* ... display for double ... */ return null; }
    public static int[][] add(int[][] a, int[][] b) { /* ... same as before ... */ return null; }
    public static int[][] multiply(int[][] a, int[][] b) { /* ... same as before ... */ return null; }
    public static int[][] transpose(int[][] matrix) { /* ... same as before ... */ return null; }

    // New method from Q14
    public static int[][] subtract(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    // New methods from Q15
    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }
    
    public static int determinant3x3(int[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1]) -
               m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0]) +
               m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    public static double[][] inverse2x2(int[][] matrix) {
        int det = determinant2x2(matrix);
        if (det == 0) return null; // No inverse exists

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / (double) det;
        inverse[0][1] = -matrix[0][1] / (double) det;
        inverse[1][0] = -matrix[1][0] / (double) det;
        inverse[1][1] = matrix[0][0] / (double) det;
        return inverse;
    }

    public static void main(String[] args) {
        System.out.println("Matrix C (2x2):");
        int[][] matrixC = {{4, 7}, {2, 6}};
        displayMatrix(matrixC);
        
        System.out.println("\nMatrix D (2x2):");
        int[][] matrixD = {{1, 2}, {3, 5}};
        displayMatrix(matrixD);

        System.out.println("\nC - D:");
        displayMatrix(subtract(matrixC, matrixD));

        System.out.println("\nDeterminant of C: " + determinant2x2(matrixC));

        System.out.println("\nInverse of C:");
        double[][] invC = inverse2x2(matrixC);
        if(invC != null) displayMatrix(invC); else System.out.println("Inverse does not exist.");

        System.out.println("\nMatrix E (3x3):");
        int[][] matrixE = {{1, 2, 3}, {0, 1, 4}, {5, 6, 0}};
        displayMatrix(matrixE);
        System.out.println("\nDeterminant of E: " + determinant3x3(matrixE));
    }
}
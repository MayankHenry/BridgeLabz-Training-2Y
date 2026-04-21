public class NQueensOptimized {
    public boolean solveNQueens(int n) {
        int[] queens = new int[n];
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        
        return backtrack(0, n, queens, cols, d1, d2);
    }

    private boolean backtrack(int row, int n, int[] queens, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) {
            return true; 
        }

        for (int col = 0; col < n; col++) {
            int id1 = row - col + n;
            int id2 = row + col;

            if (cols[col] || d1[id1] || d2[id2]) {
                continue;
            }

            queens[row] = col;
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;

            if (backtrack(row + 1, n, queens, cols, d1, d2)) {
                return true;
            }

            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }

        return false;
    }
}
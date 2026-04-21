import java.util.*;

class IslandCounter {

    static int countIslandsDFS(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfs(int[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {
        if(row < 0 || row >= rows || col < 0 || col >= cols) return;
        if(grid[row][col] == 0 || visited[row][col]) return;

        visited[row][col] = true;
        dfs(grid, visited, row - 1, col, rows, cols);
        dfs(grid, visited, row + 1, col, rows, cols);
        dfs(grid, visited, row, col - 1, rows, cols);
        dfs(grid, visited, row, col + 1, rows, cols);
    }

    static int countIslandsBFS(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    bfs(grid, visited, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            for(int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                        && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    static int countIslandsDFSDiagonal(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    dfsDiagonal(grid, visited, i, j, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    static void dfsDiagonal(int[][] grid, boolean[][] visited, int row, int col, int rows, int cols) {
        if(row < 0 || row >= rows || col < 0 || col >= cols) return;
        if(grid[row][col] == 0 || visited[row][col]) return;

        visited[row][col] = true;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int[] dir : directions) {
            dfsDiagonal(grid, visited, row + dir[0], col + dir[1], rows, cols);
        }
    }

    static void printGrid(int[][] grid) {
        for(int[] row : grid) {
            StringBuilder sb = new StringBuilder("   ");
            for(int cell : row) {
                sb.append(cell).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1}
        };

        System.out.println("=== Problem 4: Island Counter ===\n");

        System.out.println("   Input Grid:");
        printGrid(grid);

        System.out.println("\na) Graph Modeling:");
        System.out.println("   Vertices: Each cell with value 1 (land) is a vertex");
        System.out.println("   Edges: Two land cells are connected if they are horizontally");
        System.out.println("   or vertically adjacent. This forms an implicit graph where");
        System.out.println("   we don't need an explicit adjacency list.\n");

        int dfsCopy[][] = new int[grid.length][grid[0].length];
        int bfsCopy[][] = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            dfsCopy[i] = grid[i].clone();
            bfsCopy[i] = grid[i].clone();
        }

        System.out.println("b) DFS Island Count: " + countIslandsDFS(dfsCopy));
        System.out.println("   Algorithm: Iterate through every cell. When an unvisited land cell");
        System.out.println("   is found, start DFS to mark all connected land cells as visited.");
        System.out.println("   Each DFS call discovers one complete island.\n");

        System.out.println("c) BFS Island Count: " + countIslandsBFS(bfsCopy));
        System.out.println("   Algorithm: Same iteration approach, but uses BFS (queue) instead");
        System.out.println("   of DFS (recursion/stack) to explore connected land cells.\n");

        System.out.println("d) Complexity Analysis:");
        System.out.println("   Let R = rows, C = columns");
        System.out.println("   DFS - Time: O(R x C), Space: O(R x C) for visited array + O(R x C)");
        System.out.println("         worst case recursion stack if entire grid is land");
        System.out.println("   BFS - Time: O(R x C), Space: O(R x C) for visited array + O(min(R,C))");
        System.out.println("         for queue in worst case");
        System.out.println("   Both have same time complexity. BFS has slightly better space");
        System.out.println("   complexity since the queue size is bounded by the perimeter.\n");

        System.out.println("e) Diagonal Connections:");
        System.out.println("   With 4-directional (no diagonal): " + countIslandsDFS(grid) + " islands");
        int[][] freshGrid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1}
        };
        System.out.println("   With 8-directional (with diagonal): " + countIslandsDFSDiagonal(freshGrid) + " islands");
        System.out.println("   Change: Instead of 4 directions (up, down, left, right),");
        System.out.println("   we check 8 directions (adding 4 diagonals).");
        System.out.println("   The center '1' at (2,2) connects diagonally to (3,3) which");
        System.out.println("   connects to the bottom-right island, merging them into fewer islands.");
    }
}

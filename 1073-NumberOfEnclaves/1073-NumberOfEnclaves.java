// Last updated: 8/9/2026, 6:38:11 PM
class Solution {
    void dfs(int row, int col, int[][] vis, int[][] grid, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, delRow, delCol);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] vis = new int[n][m];

        // first row & last row
        for (int j = 0; j < m; j++) {
            // first
            if (vis[0][j] == 0 && grid[0][j] == 1) {
                dfs(0, j, vis, grid, delRow, delCol);
            }
            //last
            if (vis[n - 1][j] == 0 && grid[n - 1][j] == 1) {
                dfs(n - 1, j, vis, grid, delRow, delCol);
            }

        }

        // first col & last col
        for (int i = 0; i < n; i++) {
            // first
            if (vis[i][0] == 0 && grid[i][0] == 1) {
                dfs(i, 0, vis, grid, delRow, delCol);
            }
            // last
            if (vis[i][m - 1] == 0 && grid[i][m - 1] == 1) {
                dfs(i, m - 1, vis, grid, delRow, delCol);
            }
        }
        // entire 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
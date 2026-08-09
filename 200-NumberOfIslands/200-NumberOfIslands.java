// Last updated: 8/9/2026, 6:39:01 PM
class Solution {

    private void dfs(int row, int col, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // Mark as visited
        grid[row][col] = '0';

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {

            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n &&
                ncol >= 0 && ncol < m &&
                grid[nrow][ncol] == '1') {

                dfs(nrow, ncol, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {

                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }
}
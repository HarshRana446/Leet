// Last updated: 9/15/2026, 3:33:04 PM
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(m - 1, n - 1, obstacleGrid, dp);
    }

    int f(int m, int n, int[][] grid, int[][] dp) {
        if (m < 0 || n < 0 || grid[m][n] == 1) {
            return 0;
        }
        if (m >= 0 && n >= 0 && grid[m][n] == -1)
            return 0;

        if (m == 0 && n == 0) {
            return 1;
        }

        if (dp[m][n] != -1)
            return dp[m][n];
        int up = f(m - 1, n, grid, dp);
        int left = f(m, n - 1, grid, dp);

        return dp[m][n] = up + left;
    }
}
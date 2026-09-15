// Last updated: 9/15/2026, 3:33:01 PM
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(n - 1, m - 1, grid, dp);
    }

    int f(int n, int m, int[][] grid, int[][] dp) {
        if (n == 0 && m == 0)
            return grid[0][0];
        if (n < 0 || m < 0)
            return Integer.MAX_VALUE;
        if (dp[n][m] != -1)
            return dp[n][m];
        int up = f(n - 1, m, grid, dp);
        int left = f(n, m - 1, grid, dp);
        return dp[n][m] = grid[n][m] + Math.min(up , left);
    }
}
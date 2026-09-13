// Last updated: 9/13/2026, 5:07:50 PM
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(m - 1, n - 1, dp);
    }

    static int f(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (dp[m][n] != -1)
            return dp[m][n];
        int up = f(m - 1, n, dp);
        int left = f(m, n - 1, dp);

        return dp[m][n] = up + left;
    }
}
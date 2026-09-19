// Last updated: 9/19/2026, 6:42:30 PM
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n + 2][n + 2];
        int minc1 = 0;
        int maxc1 = 0;
        int minc2 = n - 1;
        int maxc2 = n - 1;
        dp[0][1][n] = grid[0][0] + grid[0][n - 1];
        int ans = dp[0][1][n];
        for (int r = 1; r < m; r++) {
            for (int c1 = 1; c1 <= Math.min(r + 1, n); c1++) {
                for (int c2 = Math.max(1, n - r); c2 <= n; c2++) {
                    int val1 = grid[r][c1 - 1];
                    int val2 = grid[r][c2 - 1];
                    int curr = 0;
                    for (int x = -1; x < 2; x++) {
                        for (int y = -1; y < 2; y++) {
                            curr = Math.max(curr, dp[r - 1][c1 + x][c2 + y]);
                        }
                    }
                    if (c1 == c2) {
                        curr += val1;
                    } else {
                        curr += val1 + val2;
                    }
                    dp[r][c1][c2] = curr;
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }
}

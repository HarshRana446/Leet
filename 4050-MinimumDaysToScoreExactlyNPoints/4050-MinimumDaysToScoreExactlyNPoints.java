// Last updated: 9/13/2026, 5:04:38 PM
class Solution {
    public int minDays(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1;; k++) {
                int points = k * (k + 1) / 2;
                if (points > i) {
                    break;
                }
                if (points == i) {
                    dp[i] = Math.min(dp[i], k);
                } else if (dp[i - points] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - points] + 1 + k);
                }
            }
        }
        return dp[n];
    }
}
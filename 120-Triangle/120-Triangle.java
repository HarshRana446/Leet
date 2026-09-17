// Last updated: 9/17/2026, 2:29:31 PM
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];

        return f(0, 0, triangle, dp);
    }

    int f(int i, int j, List<List<Integer>> triangle, Integer[][] dp) {
        if (i == triangle.size() - 1)
            return triangle.get(i).get(j);
        if (dp[i][j] != null)
            return dp[i][j];

        int d = triangle.get(i).get(j) + f(i + 1, j, triangle, dp);
        int dg = triangle.get(i).get(j) + f(i + 1, j + 1, triangle, dp);

        return dp[i][j] = Math.min(d, dg);
    }
}
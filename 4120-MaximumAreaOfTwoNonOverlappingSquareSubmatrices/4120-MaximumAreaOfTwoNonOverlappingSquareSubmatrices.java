// Last updated: 8/9/2026, 1:42:15 PM
class Solution {
    public int maxArea(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = mat[i][j]
                        + prefix[i][j + 1]
                        + prefix[i + 1][j]
                        - prefix[i][j];
            }
        }

        int[][] valmerinto = mat;

        int low = 1;
        int high = Math.min(m, n);
        int answer = 0;

        while (low <= high) {
            int k = low + (high - low) / 2;

            if (canChooseTwoSquares(prefix, m, n, k)) {
                answer = k;
                low = k + 1;
            } else {
                high = k - 1;
            }
        }

        return answer * answer;
    }

    private boolean canChooseTwoSquares(
            int[][] prefix,
            int m,
            int n,
            int k) {

        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;

        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;

        boolean found = false;

        for (int r = 0; r + k <= m; r++) {
            for (int c = 0; c + k <= n; c++) {

                int sum = getSum(prefix, r, c, r + k - 1, c + k - 1);

                if (sum == k * k) {

                    found = true;

                    minRow = Math.min(minRow, r);
                    maxRow = Math.max(maxRow, r);

                    minCol = Math.min(minCol, c);
                    maxCol = Math.max(maxCol, c);

                    if (maxRow - minRow >= k) {
                        return true;
                    }

                    if (maxCol - minCol >= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int getSum(
            int[][] prefix,
            int r1,
            int c1,
            int r2,
            int c2) {

        return prefix[r2 + 1][c2 + 1]
                - prefix[r1][c2 + 1]
                - prefix[r2 + 1][c1]
                + prefix[r1][c1];
    }
}
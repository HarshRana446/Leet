// Last updated: 7/27/2026, 2:29:44 PM
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxRowInd = findMax(mat, n, m, mid);
            int left = (mid > 0) ? mat[maxRowInd][mid - 1] : Integer.MIN_VALUE;
            int right = (mid < m - 1) ? mat[maxRowInd][mid + 1] : Integer.MIN_VALUE;

            if (mat[maxRowInd][mid] >= left && mat[maxRowInd][mid] >= right) {
                return new int[] { maxRowInd, mid };
            } else if (mat[maxRowInd][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    int findMax(int[][] mat, int n, int m, int col) {
        int maxVal = mat[0][col];
        int ind = 0;

        for (int i = 1; i < n; i++) {
            if (mat[i][col] > maxVal) {
                maxVal = mat[i][col];
                ind = i;
            }
        }
        return ind;
    }
}
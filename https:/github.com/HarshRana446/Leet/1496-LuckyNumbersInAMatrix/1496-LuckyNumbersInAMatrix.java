// Last updated: 7/14/2026, 2:37:36 PM
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        HashSet<Integer> minRows = new HashSet<>();
        HashSet<Integer> maxCols = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            int minVal = matrix[i][0];
            for (int j = 0; j < cols; j++) {
                minVal = Math.min(minVal, matrix[i][j]);
            }
            minRows.add(minVal);
        }

        for (int i = 0; i < cols; i++) {
            int maxVal = matrix[0][i];
            for (int j = 0; j < rows; j++) {
                maxVal = Math.max(maxVal, matrix[j][i]);
            }
            maxCols.add(maxVal);
        }

        
    List<Integer> res = new ArrayList<>();
    for(int i = 0;i<rows;i++)
    {
        for (int j = 0; j < cols; j++) {
            if (minRows.contains(matrix[i][j]) &&
                    maxCols.contains(matrix[i][j])) {
                res.add(matrix[i][j]);
            }
        }
    }return res;
}
}
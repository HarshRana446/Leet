// Last updated: 7/14/2026, 2:39:47 PM
class Solution {
    public void rotate(int[][] matrix) {
       int n = matrix.length;
       for(int i = 0; i < n; i++){
        for(int j = i + 1;j < n; j++){
            swap(matrix, i , j);
        }
       }
       for(int i = 0; i < n; i++){
        reverse(matrix, i, n - 1);
       }
    }
    void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    void reverse(int[][] matrix, int row, int right) {

        int left = 0;

        while (left < right) {
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;

            left++;
            right--;
        }
    }
}
// Last updated: 7/14/2026, 2:49:44 PM
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int index = 0;
        int row = rStart;
        int col = cStart;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int steps = 1;
        int stepCount = 0;
        while (index < rows * cols) {
            if (row >= 0 && row < rows && col >= 0 && col < cols) {
                result[index][0] = row;
                result[index][1] = col;
                index++;
            }
            row += directions[direction][0];
            col += directions[direction][1];
            stepCount++;
            if (stepCount == steps) {
                stepCount = 0;
                direction = (direction + 1) % 4;
                if (direction % 2 == 0) {
                    steps++;
                }
            }
        }
        return result;
    }
}
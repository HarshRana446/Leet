// Last updated: 8/22/2026, 6:14:51 PM
import java.util.*;

class Solution {

    public int largestIsland(int[][] grid) {

        int n = grid.length;

        // islandId -> island area
        Map<Integer, Integer> area = new HashMap<>();

        int islandId = 2;
        int maxArea = 0;

        // ------------------------------------------------
        // STEP 1: Label every island and calculate area
        // ------------------------------------------------
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {

                    int currentArea = dfs(
                            grid,
                            i,
                            j,
                            islandId
                    );

                    area.put(islandId, currentArea);

                    maxArea = Math.max(maxArea, currentArea);

                    islandId++;
                }
            }
        }

        // ------------------------------------------------
        // STEP 2: Try changing every 0 into 1
        // ------------------------------------------------
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (grid[i][j] != 0) {
                    continue;
                }

                /*
                 * Store unique neighboring islands.
                 *
                 * The same island may appear on multiple
                 * sides of this zero.
                 */
                Set<Integer> neighbors = new HashSet<>();

                if (i > 0 && grid[i - 1][j] > 1) {
                    neighbors.add(grid[i - 1][j]);
                }

                if (i + 1 < n && grid[i + 1][j] > 1) {
                    neighbors.add(grid[i + 1][j]);
                }

                if (j > 0 && grid[i][j - 1] > 1) {
                    neighbors.add(grid[i][j - 1]);
                }

                if (j + 1 < n && grid[i][j + 1] > 1) {
                    neighbors.add(grid[i][j + 1]);
                }

                // Change this 0 into 1
                int currentArea = 1;

                for (int id : neighbors) {
                    currentArea += area.get(id);
                }

                maxArea = Math.max(maxArea, currentArea);
            }
        }

        return maxArea;
    }

    // ------------------------------------------------
    // DFS: Label island and return its area
    // ------------------------------------------------
    private int dfs(
            int[][] grid,
            int row,
            int col,
            int islandId) {

        int n = grid.length;

        // Outside grid
        if (row < 0 || row >= n ||
            col < 0 || col >= n) {

            return 0;
        }

        // Not an unvisited land cell
        if (grid[row][col] != 1) {
            return 0;
        }

        // Mark island with unique ID
        grid[row][col] = islandId;

        int area = 1;

        // Up
        area += dfs(
                grid,
                row - 1,
                col,
                islandId
        );

        // Down
        area += dfs(
                grid,
                row + 1,
                col,
                islandId
        );

        // Left
        area += dfs(
                grid,
                row,
                col - 1,
                islandId
        );

        // Right
        area += dfs(
                grid,
                row,
                col + 1,
                islandId
        );

        return area;
    }
}
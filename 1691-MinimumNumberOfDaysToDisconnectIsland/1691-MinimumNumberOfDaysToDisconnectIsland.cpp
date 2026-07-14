// Last updated: 7/14/2026, 2:49:18 PM
#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    int minDays(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        // Check if the grid is initially connected
        if (!isConnected(grid)) return 0;

        // Try removing each land cell and check if the grid becomes disconnected
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (!isConnected(grid)) return 1; // If disconnected
                    grid[i][j] = 1; // Restore the cell
                }
            }
        }

        // Try removing two land cells
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = i; k < m; ++k) {
                    for (int l = (k == i ? j + 1 : 0); l < n; ++l) {
                        if (grid[i][j] == 1 && grid[k][l] == 1) {
                            grid[i][j] = 0;
                            grid[k][l] = 0;
                            if (!isConnected(grid)) return 2;
                            grid[i][j] = 1;
                            grid[k][l] = 1;
                        }
                    }
                }
            }
        }

        return 3; // If neither single nor double cell removal disconnects the grid
    }

private:
    bool isConnected(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        bool found = false;

        // Directions for moving in 4 directions
        vector<int> directions = {-1, 0, 1, 0, -1};

        // BFS to mark all cells in the same component
        auto bfs = [&](int startRow, int startCol) {
            queue<pair<int, int>> q;
            q.push({startRow, startCol});
            visited[startRow][startCol] = true;

            while (!q.empty()) {
                auto [row, col] = q.front();
                q.pop();

                for (int d = 0; d < 4; ++d) {
                    int newRow = row + directions[d];
                    int newCol = col + directions[d + 1];
                    
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                        !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                        visited[newRow][newCol] = true;
                        q.push({newRow, newCol});
                    }
                }
            }
        };

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if (found) return false; // More than one component
                    bfs(i, j);
                    found = true;
                }
            }
        }
        return found; // Should return true if exactly one island
    }
};

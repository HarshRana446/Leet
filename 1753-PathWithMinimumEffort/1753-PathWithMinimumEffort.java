// Last updated: 8/12/2026, 4:18:31 PM
class Tuple {
    int row;
    int distance;
    int col;

    Tuple(int _row, int _distance, int _col) {
        this.row = _row;
        this.distance = _distance;
        this.col = _col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.distance - y.distance);

        int n = heights.length;
        int m = heights[0].length;
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = (int) (1e9);
            }
        }
        dis[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int dr[] = { -1, 0, 1, 0 };
        int dc[] = { 0, 1, 0, -1 };

        while (pq.size() != 0) {
            Tuple it = pq.peek();
            pq.remove();
            int diff = it.distance;
            int row = it.row;
            int col = it.col;

            if (row == n - 1 && col == m - 1)
                return diff;
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newE = Math.max(
                            Math.abs(heights[nr][nc] - heights[row][col]),
                            diff);
                    if (newE < dis[nr][nc]) {
                        dis[nr][nc] = newE;
                        pq.add(new Tuple(nr, newE, nc));
                    }
                }
            }
        }
        return 0;
    }
}
// Last updated: 8/15/2026, 12:41:08 PM
class Tuple {
    int first;
    int second;
    int third;

    Tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;

        int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(1, 0, 0));

        grid[0][0] = 1;

        while (!q.isEmpty()) {
            Tuple it = q.poll();

            int dist = it.first;
            int r = it.second;
            int c = it.third;

            if (r == n - 1 && c == m - 1)
                return dist;

            for (int i = 0; i < 8; i++) {

                int newr = r + dr[i];
                int newc = c + dc[i];

                if (newr >= 0 && newr < n &&
                        newc >= 0 && newc < m &&
                        grid[newr][newc] == 0) {

                    grid[newr][newc] = 1;

                    q.add(new Tuple(dist + 1, newr, newc));
                }
            }
        }
        return -1;
    }
}
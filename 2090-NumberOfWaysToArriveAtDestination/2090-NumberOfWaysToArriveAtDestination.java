// Last updated: 8/17/2026, 4:55:11 PM
class Solution {
    public int countPaths(int n, int[][] roads) {
        final long MOD = 1_000_000_007L;

        long[][] graph = new long[n][n];

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph[u][v] = time;
            graph[v][u] = time;
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        boolean[] visited = new boolean[n];

        java.util.Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        for (int i = 0; i < n; i++) {

            // Find unvisited node with minimum distance
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visited[j] &&
                    (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }

            visited[u] = true;

            // Relax all neighbors
            for (int v = 0; v < n; v++) {
                if (graph[u][v] == 0) {
                    continue;
                }

                long newDist = dist[u] + graph[u][v];

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                }
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}
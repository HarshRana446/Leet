// Last updated: 8/25/2026, 1:45:46 PM
class Solution {
    private int[] head;
    private int[] to;
    private int[] next;
    private int edgeCount;
    private int[] timeVisited;
    private int[] low;
    private int time;
    private List<List<Integer>> result;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int m = connections.size();
        head = new int[n];
        java.util.Arrays.fill(head, -1);
        to = new int[m * 2];
        next = new int[m * 2];
        edgeCount = 0;

        for (int i = 0; i < m; i++) {
            List<Integer> conn = connections.get(i);
            int u = conn.get(0);
            int v = conn.get(1);

            to[edgeCount] = v;
            next[edgeCount] = head[u];
            head[u] = edgeCount++;

            to[edgeCount] = u;
            next[edgeCount] = head[v];
            head[v] = edgeCount++;
        }

        timeVisited = new int[n];
        low = new int[n];
        time = 0;
        result = new ArrayList<>();

        dfs(0, -1);

        return result;
    }

    private void dfs(int u, int parent) {
        timeVisited[u] = low[u] = ++time;

        for (int e = head[u]; e != -1; e = next[e]) {
            int v = to[e];
            if (v == parent) {
                continue;
            }

            if (timeVisited[v] != 0) {
                low[u] = Math.min(low[u], timeVisited[v]);
            } else {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > timeVisited[u]) {
                    result.add(List.of(u, v));
                }
            }
        }
    }
}

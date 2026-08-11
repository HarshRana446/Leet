// Last updated: 8/11/2026, 4:32:57 PM
class Solution {
    boolean dfs(int node, int[][] graph, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (dfs(it, graph, vis, pathVis, check) == true) {
                    check[node] = 0;
                    pathVis[node] = 0;
                    return true;
                }
            } else if (pathVis[it] == 1 || check[it] == 0) {
                check[node] = 0;
                pathVis[node] = 0;
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];
        List<Integer> safe = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, graph, vis, pathVis, check);
            }
        }
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) {
                safe.add(i);
            }
        }
        return safe;
    }
}
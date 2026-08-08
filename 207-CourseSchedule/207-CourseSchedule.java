// Last updated: 8/8/2026, 4:41:52 PM
class Solution {
    boolean dfs(int node, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int adjacent : adj.get(node)) {
            if (vis[adjacent] == 0) {
                if (dfs(adjacent, vis, adj) == true)
                    return true;
            } else if (vis[adjacent] == 1)
                return true;
        }
        vis[node] = 2;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            adj.get(prerequisite).add(course);
        }
        int vis[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (dfs(i, vis, adj)) {
                    return false;
                }
            }
        }
        return true;
    }
}
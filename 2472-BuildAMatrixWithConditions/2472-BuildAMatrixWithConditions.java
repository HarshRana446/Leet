// Last updated: 7/14/2026, 2:48:55 PM
import java.util.*;

class Solution {
    
    int[] topoSort(int V, int[][] pairs) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : pairs) {
            int u = pair[0] - 1; // Convert to zero-based index
            int v = pair[1] - 1; // Convert to zero-based index
            adj.get(u).add(v);
        }

        int[] indegree = new int[V];
        for (int u = 0; u < adj.size(); u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) { // Zero-based index
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (res.size() != V) {
            return new int[0];
        }

        int[] ans = new int[V];
        for (int i = 0; i < V; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowToposort = topoSort(k, rowConditions);
        if (rowToposort.length == 0) {
            return new int[0][0];
        }

        int[] colToposort = topoSort(k, colConditions);
        if (colToposort.length == 0) {
            return new int[0][0];
        }

        int[][] matrix = new int[k][k];
        int[] rowIndex = new int[k];
        int[] colIndex = new int[k];

        for (int i = 0; i < k; i++) {
            rowIndex[rowToposort[i]] = i;
            colIndex[colToposort[i]] = i;
        }

        for (int i = 0; i < k; i++) {
            matrix[rowIndex[i]][colIndex[i]] = i + 1; // Convert back to one-based index
        }

        return matrix;
    }
}

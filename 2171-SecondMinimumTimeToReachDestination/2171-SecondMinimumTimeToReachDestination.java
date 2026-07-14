// Last updated: 7/14/2026, 2:49:04 PM
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // Create adjacency lists for all nodes
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // Queue for BFS
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[] {1, 0}); // Start from node 1 with distance 0

        // Initialize distances (two distances per node to store the two smallest distances)
        int[][] distances = new int[n + 1][2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        distances[1][0] = 0; // Distance to the starting node is zero

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] nodeData = queue.pollFirst();
            int current = nodeData[0], distance = nodeData[1];

            // Explore neighbors
            for (int neighbor : graph[current]) {
                // Record smallest distance
                if (distance + 1 < distances[neighbor][0]) {
                    distances[neighbor][0] = distance + 1;
                    queue.offerLast(new int[] {neighbor, distance + 1});
                } 
                // Record second smallest distance
                else if (distances[neighbor][0] < distance + 1 && distance + 1 < distances[neighbor][1]) {
                    distances[neighbor][1] = distance + 1;
                    // Early break if we reach the destination node
                    if (neighbor == n) {
                        break;
                    }
                    queue.offerLast(new int[] {neighbor, distance + 1});
                }
            }
        }

        // Calculate the total time to reach the destination node using the second smallest distance
        int totalTime = 0;
        for (int i = 0; i < distances[n][1]; ++i) {
            totalTime += time;
            // Adjust total time based on traffic signal change interval
            if (i < distances[n][1] - 1 && (totalTime / change) % 2 == 1) {
                totalTime = (totalTime + change) / change * change;
            }
        }
        return totalTime;
    }
}
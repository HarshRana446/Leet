// Last updated: 8/10/2026, 1:34:08 PM
class Solution {
    boolean check(int start, int V, int[][] graph, int[] color){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        color[start] = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();

            for(int it : graph[node]){
                if(color[it] == -1){
                    color[it] = 1 - color[node];
                    q.add(it);
                }else if(color[it] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for(int i = 0; i < n; i++){
            color[i] = -1;
        }
        for(int i = 0; i<n; i++){
            if(color[i] == -1){
                if(check(i, n, graph, color) == false){
                    return false;
                }
            }
        }
        return true;
    }
}
// Last updated: 8/6/2026, 4:47:59 PM
class Solution {
    void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int vis[]){
        vis[node] = 1;
        for(Integer it : adjLs.get(node)){
            if(vis[it] == 0){
                dfs(it, adjLs, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjL = new ArrayList<ArrayList<Integer>>();
        int n = isConnected.length;
        for(int i = 0; i < n; i++){
            adjL.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjL.get(i).add(j);
                    adjL.get(j).add(i);
                }
            }
        }
        int vis[] = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                count++;
                dfs(i, adjL, vis);
            }
        }
        return count;
    }
}
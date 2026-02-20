class Solution {
    public int findCircleNum(int[][] adj) {
        int V=adj.length;
        boolean[] vis = new boolean[V];
        int prov = 0;   // ✅ moved inside function
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(i, V, adj, vis);
                prov++;
            }
        }
        
        return prov;
        
    }

    void dfs(int node, int V, int [][] adj, boolean[] vis){
        
        vis[node] = true;
         
        for(int j = 0; j < V; j++){
            if(adj[node][j] == 1 && !vis[j]){
                dfs(j, V, adj, vis);
            }
        }
    }
}
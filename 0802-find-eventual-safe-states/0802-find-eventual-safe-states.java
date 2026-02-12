class Solution {
    public List<Integer> eventualSafeNodes(int[][] edges) {
        int V = edges.length;

        int[] state = new int[V]; 
        // 0 = unvisited
        // 1 = visiting
        // 2 = safe
        
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < V; i++){
            if(dfs(i, edges, state)){
                result.add(i);
            }
        }
        
        return result;
    }

    private boolean dfs(int node, int[][] edges, int[] state){
        
        if(state[node] == 1) return false;  // cycle detected
        if(state[node] == 2) return true;   // already safe
        
        state[node] = 1; // mark as visiting
        
        for(int nei : edges[node]){   // ✅ use edges directly
            if(!dfs(nei, edges, state)){
                return false;
            }
        }
        
        state[node] = 2; // mark safe
        return true;
    }
}

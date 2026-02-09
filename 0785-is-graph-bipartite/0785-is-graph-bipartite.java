class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;

        int []color=new int [V];
        Arrays.fill(color, -1);

        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(!check(i, V, graph, color)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check(int node, int V, int [][] adj, int []color){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        color[node]=0;
        
        while(!q.isEmpty()){
            int curr=q.poll();
            
            for(int it:adj[curr]){
                if(color[it]==-1){
                    color[it]=1-color[curr];
                    q.add(it);
                }else if(color[it]==color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}
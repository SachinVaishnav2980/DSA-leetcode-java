class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length;
        int []degree=new int[100000+1];
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];

            degree[u]++;
            degree[v]++;
            if(degree[u]==n){
                return u;
            }
            if(degree[v]==n){
                return v;
            }
        }
        return -1;
    }
}
class Solution {
    public int findCenter(int[][] edges) {
        int []degree=new int[100000+1];
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];

            degree[u]++;
            degree[v]++;
        }
        int n=edges.length;
        int ans=0;
        for(int i=0;i<degree.length;i++){
            if(degree[i]==n){
                ans=i;
            }
        }
        return ans;
    }
}
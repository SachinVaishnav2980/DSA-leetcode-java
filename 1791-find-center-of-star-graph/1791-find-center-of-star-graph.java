class Solution {
    public int findCenter(int[][] edges) {
        int []degree=new int[100000+1];
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];

            degree[u]++;
            degree[v]++;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<degree.length;i++){
            max=Math.max(max, degree[i]);
        }
        int ans=0;
        for(int i=0;i<degree.length;i++){
            if(degree[i]==max){
                ans=i;
            }
        }
        return ans;
    }
}
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long []degree=new long[n];
        for(int []edge:roads){
            int u=edge[0];
            int v=edge[1];

            degree[u]++;
            degree[v]++;
        }

        Arrays.sort(degree);
        long res=0;
        long label=1;    
        for(int i=0;i<n;i++){
            res+=(degree[i] * label);
            label++;
        }
        return res;
    }
}
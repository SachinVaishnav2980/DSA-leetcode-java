class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {

        int [][]ans=new int[n][n];

        for(int i=0;i<queries.length;i++){
            int r1=queries[i][0];
            int c1=queries[i][1];
            int r2=queries[i][2];
            int c2=queries[i][3];

            //Difference array 
            for(int j=r1;j<=r2;j++){
                ans[j][c1]+=1;

                if(c2+1<n){
                    ans[j][c2+1]-=1;
                }
            }
        }

        //prefixSum

        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                ans[i][j]+=ans[i][j-1];
            }
        }
        return ans;
    }
}
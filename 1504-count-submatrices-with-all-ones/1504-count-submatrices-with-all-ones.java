class Solution {
    public int numSubmat(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int []heights=new int[m];
        int ans=0;

        for(int i=0;i<n;i++){

            //step1 
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    heights[j]++;
                }else{
                    heights[j]=0;
                }
            }

            //step2 
            for(int j=0;j<m;j++){
                int min=heights[j];
                for(int k=j;k>=0;k--){
                    min=Math.min(min, heights[k]);
                    ans+=min;
                }
            }
        }
        return ans;
    }
}
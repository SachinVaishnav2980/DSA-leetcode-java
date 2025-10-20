class Solution {
    public void setZeroes(int[][] matrix) {
        List<List<Integer>> list=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    List<Integer> mid=new ArrayList<>();
                    mid.add(i);
                    mid.add(j);
                    list.add(mid);
                }
            }
        }

        for(List<Integer> element:list){
            int i=element.get(0);
            int j=element.get(1);

            //For row changes
            for(int a=j;a<m;a++){
                matrix[i][a]=0;
            }

            for(int b=j;b>=0;b--){
                matrix[i][b]=0;
            }

            //For column changes
            for(int c=i;c<n;c++){
                matrix[c][j]=0;
            }

            for(int d=i;d>=0;d--){
                matrix[d][j]=0;
            }
        }
    }
}
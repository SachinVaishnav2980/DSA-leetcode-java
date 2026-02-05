class Solution {

    class Pair{
        int row;
        int col;
        int steps;
        
        public Pair(int row, int col, int steps){
            this.row=row;
            this.col=col;
            this.steps=steps;
        }
    }
    
    int []delRow={-1, 0, 1, 0};
    int []delCol={0, 1, 0, -1};

    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        int [][] ans=new int[n][m];
        boolean [][]vis=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=true;
                    q.offer(new Pair(i, j, 0));
                }else{
                    vis[i][j]=false;
                }
            }
        }

        while(!q.isEmpty()){
            Pair p=q.poll();
            int sr=p.row;
            int sc=p.col;
            int steps=p.steps;

            ans[sr][sc]=steps;

            for(int i=0;i<4;i++){
                int nr=sr+delRow[i];
                int nc=sc+delCol[i];
                
                
                if(nr>=0 && nr<mat.length && nc>=0 && nc<mat[0].length 
                    && !vis[nr][nc]){
                        vis[nr][nc]=true;
                        q.offer(new Pair(nr, nc, steps+1));
                }
            }
        }
        return ans;
    }
}
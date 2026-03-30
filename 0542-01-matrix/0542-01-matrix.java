class Solution {
    class Pair{
        int xCord;
        int yCord;
        int dist;

        public Pair (int x, int y, int dis){
            this.xCord=x;
            this.yCord=y;
            this.dist=dis;
        }
    }

    int []dx={-1, 0, 1, 0};
    int dy[]={0, 1, 0, -1};

    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        Queue<Pair> q=new LinkedList<>();
        boolean [][]vis=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i, j, 0));
                    vis[i][j]=true;
                }
            }
        }


        while (!q.isEmpty()) {
            Pair p=q.poll();

            int x=p.xCord;
            int y=p.yCord;
            int dist=p.dist;

            mat[x][y]= dist;

            for(int i=0;i<4;i++){
                int nrow=x+dx[i];
                int ncol=y+dy[i];

                if(isValid(mat, nrow, ncol) && !vis[nrow][ncol]){
                    vis[nrow][ncol]=true;

                    q.add(new Pair(nrow, ncol, dist+1));
                }
            }
        }
        return mat;
    }

    public boolean isValid(int [][]mat, int row, int col){
        int n=mat.length;
        int m=mat[0].length;

        return row>=0 && row<n && col>=0 && col<m;
    }
}
class Solution {
    //Pair class for queue
    class Pair{
        int row;
        int col;
        int time;
        
        public Pair(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue =new LinkedList<>();
        
        int n=grid.length;
        int m=grid[0].length;
        
        int [][]ans=new int [n][m];
        int []delRow={-1, 0, 1, 0};
        int []delCol={0, 1, 0, -1};
        int cntFresh=0;
        int maxTime=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i, j, 0));
                    ans[i][j]=2;
                }
                if(grid[i][j]==1) cntFresh++;
            }
        }
        int cnt=0;
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            int row=p.row;
            int col=p.col;
            int time=p.time;
            maxTime=Math.max(time, maxTime);
            for(int i=0;i<4;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && 
                    ans[nrow][ncol]!=2 && grid[nrow][ncol]==1){
                        ans[nrow][ncol]=2;
                        queue.offer(new Pair(nrow, ncol, time+1));
                        cnt++;
                    }
            }
        }
        if(cnt!=cntFresh) return -1;
        return maxTime;
    }
}
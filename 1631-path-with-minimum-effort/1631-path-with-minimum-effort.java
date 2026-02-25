class Solution {
    class Node{
        int diff;
        int row;
        int col;
        public Node(int x, int y, int z){
            this.diff=x;
            this.row=y;
            this.col=z;
        }
    }
    int []dx={-1, 0, 1, 0};
    int []dy={0, 1, 0, -1};

    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int [][]dist =new int [n][m];
        for(int []dis:dist){
            Arrays.fill(dis, (int)(1e9));
        }

        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)-> a.diff - b.diff);

        dist[0][0]=0;

        pq.add(new Node(0, 0, 0));

        while(!pq.isEmpty()){

            Node node=pq.poll();
            int diff=node.diff;
            int row=node.row;
            int col=node.col;

            if(row==n-1 && col==m-1) return diff;

            for(int i=0;i<4;i++){
                int nrow=row+dx[i];
                int ncol=col+dy[i];

                if(isValid(heights, nrow, ncol)){

                    int absDiff=Math.abs(heights[row][col]-heights[nrow][ncol]);
                    int maxDiff=Math.max(diff, absDiff);
                    
                    if(dist[nrow][ncol]>maxDiff){
                        dist[nrow][ncol]=maxDiff;
                        pq.add(new Node(maxDiff, nrow, ncol));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }

    boolean isValid(int [][]heights, int row, int col){
        int n=heights.length;
        int m=heights[0].length;

        return row>=0 && col>=0 && row<n && col<m;
    }
}
class Solution {
    class Pair<F, S>{
        F first;
        S second;

        public Pair(F first, S second){
            this.first=first;
            this.second=second;
        }

    }
    public int cutOffTree(List<List<Integer>> forest) {
        int n=forest.size();
        int m=forest.get(0).size();

        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq =
    new PriorityQueue<>((a, b) -> a.first - b.first);


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(forest.get(i).get(j)>1){
                    pq.add(new Pair<>(forest.get(i).get(j), new Pair<>(i, j)));
                }
            }
        }

        int totalSteps=0;

        int startx=0;
        int starty=0;

        while (!pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> tree = pq.poll();
            int targetx=tree.second.first;
            int targety=tree.second.second;

            int steps=bfs(forest, startx, starty, targetx, targety);

            if (steps==-1) {
                return -1;
            }

            totalSteps+=steps;
            startx=targetx;
            starty=targety;
        }
        return totalSteps;
    }

    int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty){
        if (sx==tx && sy==ty) {
            return 0;
        }

        int n=forest.size();
        int m=forest.get(0).size();

        Queue<int []> queue=new LinkedList<>();
        boolean [][]visited=new boolean[n][m];
        queue.add(new int[]{sx, sy, 0});

        visited[sx][sy]=true;
        int [][]dir={{0,-1},{-1,0},{0,1},{1,0}};

        while (!queue.isEmpty()) {
            int curr[]=queue.poll();
            int x=curr[0];
            int y=curr[1];
            int steps=curr[2];

            for(int []d:dir){
                int nx=x+d[0];
                int ny=y+d[1];

                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && forest.get(nx).get(ny)!=0){

                    if(nx==tx && ny==ty) return steps+1;
                    visited[nx][ny]=true;
                    queue.add(new int[]{nx, ny, steps+1});
                }
            }
        }
        return -1;
    }
}
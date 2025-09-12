class Solution {
    class Pair<F, S> {
    F first;
    S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
}
}
    public int kthSmallest(int[][] matrix, int k) {
        List<Pair<Integer,Pair<Integer,Integer>>> list=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            list.add(new Pair<>(matrix[i][0], new Pair<>(i, 0)));  
        }

        PriorityQueue<Pair<Integer, Pair<Integer,Integer>>> pq= new PriorityQueue<>((a, b) -> a.first - b.first);
        for (Pair<Integer, Pair<Integer,Integer>> p : list) {
        pq.add(p);
    }   
        int ans=0;
        while (k>0) {
            Pair<Integer,Pair<Integer,Integer>> element=pq.poll();
            ans=element.first;
            int i=element.second.first;
            int j=element.second.second;
            if(j+1<m){
                pq.add(new Pair<>(matrix[i][j+1], new Pair<>(i, j+1)));
            }
            k--;
        } 
        return ans;
    }
}
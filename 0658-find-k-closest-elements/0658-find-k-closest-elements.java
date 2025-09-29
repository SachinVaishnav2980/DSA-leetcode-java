class Solution {
    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
        (a, b) -> a.first == b.first ? b.second - a.second : b.first - a.first
    );
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair(Math.abs(arr[i] - x), arr[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }
        List<Integer> res=new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.peek().second);
            pq.poll();
        }
        Collections.sort(res);
        return res;
    }
}
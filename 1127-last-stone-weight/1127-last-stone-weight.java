class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==1){
            return 1;
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int element:stones){
            pq.add(element);
        }
        while(pq.size()>1){
            int max=pq.poll();
            pq.add(Math.abs(max-pq.poll()));
        }
        return pq.poll();

    }
}
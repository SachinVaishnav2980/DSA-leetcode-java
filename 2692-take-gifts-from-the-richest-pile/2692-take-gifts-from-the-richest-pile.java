class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int element:gifts){
            pq.add((long)element);
        }

        while(k>0 && pq.size()>0){
            long maxGift=pq.poll();
            pq.add((long)Math.sqrt(maxGift));
            k--;
        } 
        long sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}
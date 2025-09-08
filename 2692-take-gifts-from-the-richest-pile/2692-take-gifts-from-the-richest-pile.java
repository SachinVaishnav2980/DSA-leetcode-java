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
        List<Long> list=new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        long sum=0;
        for(long element:list){
            sum+=element;
        }
        return sum;
    }
}
class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq=new PriorityQueue<>();
        Set<Long> set=new HashSet<>();
        pq.add(1L);
        long curr=1;
        while (n>0) {
            curr=pq.poll();
            n--;
            //just putting the multiple for future
            if(!set.contains(curr*2)){
                set.add(curr*2);
                pq.add(curr*2);
            }
            if(!set.contains(curr*3)){
                set.add(curr*3);
                pq.add(curr*3);
            }
            if(!set.contains(curr*5)){
                set.add(curr*5);
                pq.add(curr*5);
            }
        }
        return (int)curr;
    }
}
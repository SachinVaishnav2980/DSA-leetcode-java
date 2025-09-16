class Solution {
    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> queue=new PriorityQueue<>((a, b)->(b.first+b.second)-(a.first+a.second));
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                Pair p=new Pair(nums1[i], nums2[j]);
                if(queue.size()<k){
                    queue.add(p);
                }else if(queue.peek().first+queue.peek().second>nums1[i]+nums2[j]){
                    queue.poll();
                    queue.add(p);
                }else{
                    break;
                }
            }
        }

        List<List<Integer>> list=new ArrayList<>();
        while (k>0) {
            list.add(Arrays.asList(queue.peek().first,queue.peek().second));
            queue.poll();
            k--;
        }

        return list;
    }
}
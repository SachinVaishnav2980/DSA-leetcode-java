class Solution {
    class Pair{
        int key;
        int freq;
        public Pair(int key, int freq){
            this.key=key;
            this.freq=freq;
        }
}
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int arr[]=new int[k];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size()>k){
                pq.poll();
            }
        }
        for(int i=k-1;i>=0;i--){
            arr[i] = pq.poll().key;
        }
        return arr;
    }
}
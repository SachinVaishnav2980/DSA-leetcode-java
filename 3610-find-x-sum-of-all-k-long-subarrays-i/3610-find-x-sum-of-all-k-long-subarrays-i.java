class Solution {
    class Pair{
        int val;
        int freq;

        public Pair(int val, int freq){
            this.val=val;
            this.freq=freq;
        }
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
        int i=0;
        int j=0;
        int ans[]=new int [n-k+1];
        int z=0;
        Map<Integer, Integer> map=new HashMap<>();
        while(j<n){
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);

            if(j-i+1==k){
                ans[z++]=findXSum(map, x);
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
    map.remove(nums[i]);
}
                i++;
            }
            j++;
        }
        return ans;
    }

    int findXSum(Map<Integer, Integer> map, int x){
        int sum=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> (a.freq == b.freq ? a.val - b.val : a.freq - b.freq));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size()>x){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            sum+=p.val*p.freq;
        }
        return sum;
    }
}
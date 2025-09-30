class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq=new HashMap<>();
        Map<Integer, Integer> need=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }

        for(int x:nums){
            if(freq.get(x)==0) continue;

            if(need.getOrDefault(x, 0)>0){
                freq.put(x, freq.get(x)-1);
                need.put(x, need.get(x)-1);
                need.put(x+1, need.getOrDefault(x+1, 0)+1);
            }else if(freq.getOrDefault(x+1, 0)>0 && freq.getOrDefault(x+2, 0)>0){
                freq.put(x, freq.get(x)-1);
                freq.put(x+1, freq.get(x+1)-1);
                freq.put(x+2, freq.get(x+2)-1);
                need.put(x+3, need.getOrDefault(x+3, 0)+1);
                
            }else{
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxValue=Arrays.stream(nums).max().getAsInt()+k;
        int diff[]=new int [maxValue+2];
        Map<Integer, Integer> freq=new HashMap<>();
        
        //Freq calc + diff array
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
            int left=Math.max(nums[i]-k, 0);  //negative value check
            int right=Math.min(nums[i]+k, maxValue);   //index out of bound check

            diff[left]++;
            diff[right+1]--;
        }

        //cumulative sum
        int result=1;
        for(int target=0;target<=maxValue;target++){
            if(target>0) diff[target]+=diff[target-1];

            int targetFreq = freq.getOrDefault(target, 0);
            int needConv=diff[target]-targetFreq;

            int maxPossibleFreq=Math.min(needConv, numOperations);
            
            result = Math.max(result, targetFreq + maxPossibleFreq);
        }
        return result;
    }
}
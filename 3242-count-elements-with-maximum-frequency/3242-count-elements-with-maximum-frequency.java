class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int element:nums){
            map.put(element, map.getOrDefault(element, 0)+1);
        }
        int max=0;
        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            max=Math.max(max, entry.getValue());
        }
        int total=0;
        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
            if(entry.getValue()==max){
                total+=(max);
            }
        }
        return total;
    }
}
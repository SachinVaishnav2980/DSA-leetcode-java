class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int element:nums){
            if(element>0){
                set.add(element);
            }
        }
        return set.size();
    }
}
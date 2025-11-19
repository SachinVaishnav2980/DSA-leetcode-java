class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set=new HashSet<>();
        for(int element:nums){
            set.add(element);
        }   


        while(set.contains(original)){
            original*=2;
        }
        return original;
    }
}
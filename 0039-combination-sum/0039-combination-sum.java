class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        combinationSum(candidates, target, list, ans, 0);
        return ans;
    }

    public void combinationSum(int []candidates, int target, List<Integer> list, List<List<Integer>> ans, int index){
        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return ;
        }
        if(candidates[index]<=target){
            list.add(candidates[index]);
            combinationSum(candidates, target-candidates[index], list, ans, index);
            list.remove(list.size()-1);
        }
        combinationSum(candidates, target, list, ans, index+1);
    }
}
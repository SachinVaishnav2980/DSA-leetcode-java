class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }
    public void combinationSum( int index, int []candidates, int target, List<Integer> list, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return ;
        }

        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            list.add(candidates[i]);
            combinationSum(i+1, candidates, target-candidates[i], list, ans);
            list.remove(list.size()-1);
        }
    }
}
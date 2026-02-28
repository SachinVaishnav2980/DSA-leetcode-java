class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void solve(int []nums, int i, List<Integer> list, List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(list));
            return ;
        }

        list.add(nums[i]);
        solve(nums, i+1, list, res);
        list.remove(list.size()-1);
        solve(nums, i+1, list, res);
    }
}
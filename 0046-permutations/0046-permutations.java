class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        solve(nums, 0, res);
        return res;
    }

    void solve(int []nums, int index, List<List<Integer>> res){
        if(index==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            res.add(new ArrayList<>(list));
            return ;
        }

        for(int j=index;j<nums.length;j++){
            swap(nums, index, j);
            solve(nums, index+1, res);
            swap(nums, index, j);
        }
    }

    void swap(int []nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
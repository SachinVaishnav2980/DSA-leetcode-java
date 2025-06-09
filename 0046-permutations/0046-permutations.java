class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        permutation(nums, ans, 0);
        return ans;

    }

    public void permutation(int []nums, List<List<Integer>> ans, int index){
        if(index==nums.length){
            List<Integer> ds=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }
        for(int i=index;i<nums.length;i++){
            swap(nums, i, index);
            permutation(nums, ans, index+1);
            swap(nums, i, index);
        }
    }

    public void swap(int []arr, int first, int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
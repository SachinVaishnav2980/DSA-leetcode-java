class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minsum=Integer.MAX_VALUE;
        int n=nums.size();
        for(int i=0;i<nums.size();i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums.get(j);
                if(j-i+1>=l && j-i+1<=r && sum>0){
                    minsum=Math.min(minsum,sum);
                }
            }

        }
        return (minsum==2147483647) ? -1:minsum;
    }
}
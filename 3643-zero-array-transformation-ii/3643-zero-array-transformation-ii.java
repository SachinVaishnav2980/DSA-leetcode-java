class Solution {
    private int n;
    private int q;

    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;

        if (Arrays.stream(nums).allMatch(x -> x == 0)) {
            return 0; //no query required because all are already zero
        }

        int start=0;
        int end=q-1;
        int k=-1;
        while(start<=end){
            int mid=start+(end-start)/2;

            if(checkIsZeroArray(nums, queries, mid)){
                k=mid+1;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return k;
    }

    boolean checkIsZeroArray(int []nums, int [][]queries, int mid){
        int n=nums.length;
        int []diff=new int [n];

        //Build diff array
        for(int i=0;i<=mid;i++){
            int left=queries[i][0];
            int right=queries[i][1];
            int x=queries[i][2];

            diff[left]+=x;
            if(right+1<n) diff[right+1]-=x;
        }

        //prefix sum
        int cumScore=0;
        for(int i=0;i<n;i++){
            cumScore+=diff[i];
            diff[i]=cumScore;

            if(nums[i]-diff[i]>0) return false;
        }

        return true;
    }
}
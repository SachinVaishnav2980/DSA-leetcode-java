class Solution {
    public int maximizeWin(int[] arr, int k) {
        int n= arr.length;
        int start=0;
        int ans=0;
        int []dp=new int[n];
        for(int end=0;end<n;end++){
            while(arr[end]-arr[start]>k){
                start++;
            }
            int curr=end-start+1;
            if(start>0) curr+=dp[start-1];
            ans=Math.max(ans, curr);
            int pehle=0;
            if(end>0) pehle=dp[end-1];
            dp[end]=Math.max(pehle, end-start+1);
        }
        return ans;
    }
}
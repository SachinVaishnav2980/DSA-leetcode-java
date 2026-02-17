class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int []suffix=new int[n+1];
        int []prefix=new int[n+1];

        for(int i=1;i<=n;i++){
            //count of N before i
            prefix[i] = prefix[i - 1] + (customers.charAt(i - 1) == 'N' ? 1 : 0);

        }

        for(int i=n-1;i>=0;i--){
            //count of Y after i
            suffix[i]=suffix[i+1]+(customers.charAt(i)=='Y'?1:0);
        }

        int ans=0;
        int minPenalty=Integer.MAX_VALUE;
        for(int i=0;i<=n;i++){
            int penalty=prefix[i]+suffix[i];
            if(penalty<minPenalty){
                minPenalty=penalty;
                ans=i;
            }
        }
        return ans;
    }
}
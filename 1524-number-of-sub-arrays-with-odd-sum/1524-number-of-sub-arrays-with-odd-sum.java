class Solution {
    // EVEN + ODD = ODD
    // ODD + EVEN = ODD
    int MOD=1000000007;
    public int numOfSubarrays(int[] arr) {
        int n=arr.length;

        int sum=0;
        int evenCount=1;
        int oddCount=0;

        int totalCount=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];

            // if sum is even check odd count
            if(sum%2==0){
                totalCount=(totalCount+oddCount)%MOD;
                evenCount++;
            }else{
                totalCount=(totalCount+evenCount)%MOD;
                oddCount++;
            }
        }
        return totalCount%MOD;
    }
}
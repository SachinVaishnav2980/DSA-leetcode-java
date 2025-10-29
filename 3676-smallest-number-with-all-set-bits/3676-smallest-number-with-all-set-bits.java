class Solution {
    public int smallestNumber(int n) {
        int mask=0;
        int num1=n;
        while(n>0){
            mask=mask*10+1;
            n=n/2;
        }
        int i=0;
        int ans=0;
        while(mask>0){
            int digit=mask%10;
            ans+=digit*Math.pow(2, i);
            i++;
            mask=mask/10;
        }
        return ans;
    }
}
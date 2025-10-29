class Solution {
    public int smallestNumber(int n) {
        int bits=0;
        while(n>0){
            bits++;
            n=n/2;
        }
        int ans=(int)Math.pow(2, bits);
        return ans-1;
    }
}
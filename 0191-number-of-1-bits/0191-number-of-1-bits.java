class Solution {
    public int hammingWeight(int n) {
        int count=0;
        return helper(n, count);
    }

    int helper(int n, int count){
        if(n==0) return count;

        if((n&1)==1) count++;
        return helper(n>>1, count);
    }
}
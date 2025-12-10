class Solution {
    public int countPermutations(int[] complexity) {
        int n=complexity.length;
        long prem=1;
        int MOD= 1000000007;
        for(int i=1;i<n;i++){
            if(complexity[i]<=complexity[0]) return 0;

            prem=(prem*i)%MOD;
        }
        return (int)prem;
    }
}
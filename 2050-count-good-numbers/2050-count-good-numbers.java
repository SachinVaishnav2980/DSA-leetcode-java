class Solution {
    int mod = 1000000007;
    public int countGoodNumbers(long n) {
           if(n == 1)
             return 5;
           long evenpos = (n+1) / 2, oddpos = n / 2;
           long even = power(5,evenpos) % mod;
           long odd = power(4,oddpos) % mod;
           return (int) ((even * odd) % mod);
    }
    private long power(long a, long b){
        if(b == 1)
          return a;
        long half = power(a, b / 2) % mod;
        long ans = (half * half) % mod;
        if(b % 2 != 0)
           ans = (ans * a) % mod;
        return ans;
    }
}
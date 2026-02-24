class Solution {
    
    int mod = 1000000007;
    
    public int numberOfArrays(String s, int k) {
        Long[] dp = new Long[s.length()];
        return (int)helper(0, s, k, dp);
    }
    
    private long helper(int index, String s, int k, Long[] dp) {
        
        // Base case
        if(index == s.length()) return 1;
        
        // Leading zero case
        if(s.charAt(index) == '0') return 0;
        
        // Already computed
        if(dp[index] != null) return dp[index];
        
        long count = 0;
        long number = 0;
        
        for(int i = index; i < s.length(); i++) {
            number = number * 10 + (s.charAt(i) - '0');
            
            if(number > k) break;
            
            count = (count + helper(i + 1, s, k, dp)) % mod;
        }
        
        return dp[index] = count;
    }
}
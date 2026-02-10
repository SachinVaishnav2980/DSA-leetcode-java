class Solution {
    int [][]dp;
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new int[n+1][m+1];
        for(int []e:dp){
            Arrays.fill(e, -1);
        }
        return solve(n-1, m-1, s, p);
    }

    private boolean solve(int i, int j, String s, String p){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;

        if(i<0 && j>=0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*') return false;
            }
            return true;
        }

        if(dp[i+1][j+1]!=-1) return dp[i+1][j+1]==1;
        //rec
        boolean ans;
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
            ans=solve(i-1, j-1, s, p);
        }
        else if(p.charAt(j)=='*'){
            ans= solve(i-1, j, s, p) || solve(i, j-1, s, p);
        }else{
            ans= false;
        }
        dp[i + 1][j + 1] = ans ? 1 : 0;
        return ans;
    }
}
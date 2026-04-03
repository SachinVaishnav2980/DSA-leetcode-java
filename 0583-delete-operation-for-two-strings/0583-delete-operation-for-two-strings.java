class Solution {
    public int minDistance(String word1, String word2) {
        return minOperations(word1, word2);
    }

    public int minOperations(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int [][]dp=new int [n+1][m+1];
        int lcsLen=lcs(s1, s2, dp);

        int deletions=n-lcsLen;
        int insertions=m-lcsLen;

        return deletions+insertions;
    }

    public int lcs(String s1, String s2, int [][]dp){
        int n=s1.length();
        int m=s2.length();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                boolean match=s1.charAt(i-1)==s2.charAt(j-1);
                if(match){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
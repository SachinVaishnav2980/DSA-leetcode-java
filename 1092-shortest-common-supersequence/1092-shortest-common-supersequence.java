class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int  [][]dp=new int [n+1][m+1];
        lCS(str1, str2, dp);
        int i=n;
        int j=m;
        StringBuilder sb=new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i][j-1]>dp[i-1][j]){
                    sb.append(str2.charAt(j-1));
                    j--;
                }else{
                    sb.append(str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    void lCS(String s1, String s2, int [][]dp){
        int m=s1.length();
        int n=s2.length();
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }
}
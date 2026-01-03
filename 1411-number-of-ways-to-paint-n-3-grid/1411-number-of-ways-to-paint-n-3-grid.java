class Solution {
    int MOD=1000000007;
    int t[][];
    String []states={"RYG","RGY", "RYR", "RGR", "YRG", "YGR", "YGY", "YRY", "GRY","GYR",  "GRG", "GYG"};
    public int numOfWays(int n) {
        int result=0;
        t=new int[n][12];
        for(int i=0;i<n;i++){
            for(int col=0;col<12;col++){
                t[i][col]=-1;
            }
        }
        for(int i=0;i<12;i++){
            result=(result+solve(n-1, i))%MOD;
        }
        return result;
    }
    
    int solve(int n, int prev){
        if(n==0) return 1;

        if(t[n][prev]!=-1) return t[n][prev];

        int result=0;
        String lastPat=states[prev];
        for(int curr=0;curr<12;curr++){
            if(curr==prev) continue ;
            String currPat=states[curr];
            boolean conflict=false;
            for(int col=0;col<3;col++){
                if(lastPat.charAt(col)==currPat.charAt(col)){
                    conflict=true;
                    break;
                }
            }
            if(!conflict){
                result=(result+solve(n-1, curr))%MOD;
            }
        }
        return t[n][prev]=result;
    }
}
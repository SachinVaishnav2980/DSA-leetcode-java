class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minTime=0;
        int n=colors.length();

        int i=0;
        for(int j=1;j<n;j++){
            if(colors.charAt(i)==colors.charAt(j)){
                if(neededTime[i]<=neededTime[j]){
                    minTime+=neededTime[i];
                    i=j;
                }else{
                    minTime+=neededTime[j];
                }
            }else{
                i=j;
            }
        }
        return minTime;
    }
}
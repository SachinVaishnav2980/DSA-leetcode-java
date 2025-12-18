class Solution {
    int []dp=new int[366];
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp, -1);
        return solve(days, costs, 0);
    }

    int solve(int []days, int []costs, int index){
        if(index>=days.length) return 0;
        if(dp[index]!=-1) return dp[index];
        int j=index;
        //1-Day pass
        while(j<days.length && days[j]<days[index]+1){
            j++;
        }
        int oneday=costs[0]+solve(days, costs, j);

        //7-Day pass
        while(j<days.length && days[j]<days[index]+7){
            j++;
        }
        int sevenday=costs[1]+solve(days, costs, j);

        //30-Day pass
        while(j<days.length && days[j]<days[index]+30){
            j++;
        }
        int thirtyday=costs[2]+solve(days, costs, j);

        return dp[index]=Math.min(oneday, Math.min(sevenday, thirtyday));
    }
}
class Solution {
    int n=0;
    int [][]t=new int[2001][2001];
    Map<Integer, Integer> map=new HashMap<>();
    public boolean canCross(int[] stones) {
        n=stones.length;
        for(int []row:t){
            Arrays.fill(row, -1);
        }
        for(int i=0;i<n;i++){
            map.put(stones[i], i);
        }
        return solve(stones, 0, 0);
    }

    boolean solve(int []nums, int curridx, int lastJump){
        //Base case
        if(curridx==n-1) return true;
        if(t[curridx][lastJump]!=-1) return t[curridx][lastJump]==1;
        //Hypothesis
        boolean result=false;
        for(int i=lastJump-1;i<=lastJump+1;i++){
            if(i>0){
            int nextStone=nums[curridx]+i;
            if(map.containsKey(nextStone)){
                result=result || solve(nums, map.get(nextStone), i);
            }
            }
        }

        //final ans
        t[curridx][lastJump]=(result?1:0);
        return result;

    }
}
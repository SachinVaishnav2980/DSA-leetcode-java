class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long sum=0;
        for(int i=0;i<batteries.length;i++){
            sum+=batteries[i];
        }
        
        for(int i=batteries.length-1;i>=0;i--){
            if(sum/n >= batteries[i]) break;
            sum-=batteries[i];
            n--;
        }
        return sum/n;
    }
}
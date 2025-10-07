class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lakeLastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for(int i=0;i<n;i++){
            if(rains[i]==0){
                dryDays.add(i);
                ans[i]=1;  //temp. value
            }else{
                int val=rains[i];
                ans[i]=-1;
                if(lakeLastRain.containsKey(val)){
                    Integer dryDay = dryDays.higher(lakeLastRain.get(val));
                    if (dryDay == null) return new int[0];

                    ans[dryDay]=val;
                    dryDays.remove(dryDay);
                }

                lakeLastRain.put(val, i);
            }
        }
        return ans;
    }
}
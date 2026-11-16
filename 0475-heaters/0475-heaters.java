class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int n=houses.length;
        int m=heaters.length;

        Arrays.sort(houses);
        Arrays.sort(heaters);
        long low=0;
        long high=Arrays.stream(houses).max().getAsInt();

        for(int i=0;i<m;i++){
            if(heaters[i]>high){
                high=heaters[i];
            }
        }

        long minRad=0;
        while(low<=high){
            long mid=low+(high-low)/2;

            if(isPossible(houses, heaters, n, m, mid)){
                minRad=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return (int)minRad;
    }

    boolean isPossible(int []houses, int []heaters, int n, int m, long radius){
        int i=0;
        int j=0;

        while(i<n && j<m){
            if((long)Math.abs(heaters[j]-houses[i])<=radius){
                i++;
            }else{
                j++;
            }
        }
        return i==n;
    }
}
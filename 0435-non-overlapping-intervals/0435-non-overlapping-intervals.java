class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int i=0;
        int j=1;
        int count=0;
        while (j<intervals.length) {
            //curr array
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];
            //next array
            int nextStart=intervals[j][0];
            int nextEnd=intervals[j][1];

            //Non-Overlapping
            if(currEnd<=nextStart){
                i=j;
            } // Overlapping
            else{
                count++;
                // keep the interval with smaller end (less chance to overlap later)
                if(currEnd>nextEnd){
                    i=j;  // keep the next interval instead of current
                }
            }
            j++;
        }
        return count;
    }
}
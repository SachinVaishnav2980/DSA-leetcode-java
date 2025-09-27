class Solution {
    public static int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b)->a[1]-b[1]);

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        int totalTime=0;
        for(int c[]:courses){
            int dur=c[0];
            int lastDay=c[1];

            totalTime+=dur;
            pq.add(dur);

            if(totalTime>lastDay){
                totalTime-=pq.poll();
            }
        }
        return pq.size();
    }
}

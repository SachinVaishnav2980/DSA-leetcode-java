class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
            int currStart=0;
            int currEnd=0;
            int nextStart=0;
            int nextEnd=0;

            currStart=Integer.parseInt(event1[0].substring(0, 2))*60+Integer.parseInt(event1[0].substring(3, event1[0].length()));
            currEnd=Integer.parseInt(event1[1].substring(0, 2))*60+Integer.parseInt(event1[1].substring(3, event1[1].length()));

            nextStart=Integer.parseInt(event2[0].substring(0, 2))*60+Integer.parseInt(event2[0].substring(3, event2[0].length()));;
            nextEnd=Integer.parseInt(event2[1].substring(0, 2))*60+Integer.parseInt(event2[1].substring(3, event2[1].length()));;

            return currStart <= nextEnd && nextStart <= currEnd;
        }
}
class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant=new ArrayDeque<>();
        Queue<Integer> dire=new ArrayDeque<>();
        int n=senate.length();
        for(int i=0;i<n;i++){
            if(senate.charAt(i)=='R'){
                radiant.offer(i);
            }else{
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rindex=radiant.poll();
            int dindex=dire.poll();
            if(rindex<dindex){
                radiant.offer(rindex+n);
                
            }else{
                dire.offer(dindex+n);
            }
        }

        return radiant.isEmpty()?"Dire":"Radiant";
    }
}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        Map<Integer, Integer> map=new TreeMap<>();

        for(int element:hand){
            map.put(element, map.getOrDefault(element, 0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int element:hand){
            pq.add(element);
        }
        while(!pq.isEmpty()) {
            int curr=pq.poll();
            if(!map.containsKey(curr)) continue;


            for(int i=0;i<groupSize;i++){
                int card=curr+i;
                if(!map.containsKey(card)) return false;

                map.put(card, map.get(card)-1);

                if(map.get(card)==0){
                    map.remove(card);
                }

            }
        }   

        return true;
    }
}
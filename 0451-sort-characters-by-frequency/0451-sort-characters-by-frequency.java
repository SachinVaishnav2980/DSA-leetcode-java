class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq=new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder str=new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            Character ch=entry.getKey();
            int freq=entry.getValue();
            for(int i=0;i<freq;i++){
                   str.append(ch);
            }
        }
        return str.toString();
    }
}
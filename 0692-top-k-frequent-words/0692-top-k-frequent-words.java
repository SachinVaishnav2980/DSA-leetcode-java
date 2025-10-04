class Solution {
    class Pair{
        String word;
        int freq;
        public Pair(String word, int freq){
            this.word=word;
            this.freq=freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans=new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.freq != b.freq)
                    return b.freq - a.freq; 
                return a.word.compareTo(b.word);
            }
        );
        Map<String, Integer> map=new HashMap<>();
        for(String word: words){
            addWord(word, map, pq);
        }

        while (k>0) {
            Pair top=pq.poll();

            if(map.get(top.word)!=top.freq){
                continue;
            }else{
                ans.add(top.word);
                k--;
            } 
        }
        return ans;
    }

    void addWord(String word, Map<String, Integer> map, PriorityQueue<Pair> pq){
        map.put(word, map.getOrDefault(word, 0)+1);
        pq.add(new Pair(word, map.get(word)));
    }
}
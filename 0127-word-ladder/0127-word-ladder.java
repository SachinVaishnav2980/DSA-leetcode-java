class Solution {
    class Pair{
        String first;
        int len;
        
        public Pair(String f, int l){
            this.first=f;
            this.len=l;
        }
    }

    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        // Code here
        Set<String> set=new HashSet<>();
        //prepare hash set
        for(String str: wordList){
            set.add(str);
        }
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(startWord, 1));
        set.remove(startWord);
        //BFS approach
        while(!q.isEmpty()){
            Pair p=q.poll();
            String nextStr=p.first;
            int leng=p.len;

            //result check 
            if(nextStr.equals(targetWord)){
                return leng;
            }
            StringBuilder sb=new StringBuilder(nextStr);
            for(int i=0;i<sb.length();i++){
                char originalChar=sb.charAt(i);
                for(char ch='a';ch<='z';ch++){
                    sb.setCharAt(i, ch);
                    if(set.contains(sb.toString())){
                        q.add(new Pair(sb.toString(), leng+1));
                        set.remove(sb.toString()); 
                    }
                }
                sb.setCharAt(i, originalChar); //restore
            }
        }
        return 0;   
    }
}
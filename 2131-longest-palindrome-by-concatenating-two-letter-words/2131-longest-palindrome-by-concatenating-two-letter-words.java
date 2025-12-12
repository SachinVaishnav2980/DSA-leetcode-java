class Solution {
    public int longestPalindrome(String[] words) {
       int result=0;
       Map<String, Integer> map=new HashMap<>();

        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        boolean centerUsed=false;
        for(String word: words){
            String rev=new StringBuilder(word).reverse().toString();
            if(!rev.equals(word)){
                if(map.getOrDefault(word, 0)>0 && map.getOrDefault(rev, 0)>0){
                    map.put(word, map.get(word)-1);
                    map.put(rev, map.get(rev)-1);
                    result+=4;
                }
            }else{
                if(map.getOrDefault(word, 0)>=2){
                    map.put(word, map.get(word)-2);
                    result+=4;
                }else if(map.getOrDefault(word, 0)==1 && centerUsed==false){
                    result+=2;
                    map.put(word, map.get(word)-1);
                    centerUsed=true;
                }
            }
        }
        return result;
    }
}
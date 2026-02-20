class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();

        for(String word: wordList){
            set.add(word);
        }
        int level=0;
        //make queue of list
        Queue<List<String>> q=new LinkedList<>();
        List<String> list=new ArrayList<>();
        list.add(beginWord);
        q.add(list);
        
        List<String> usedOnLevel=new ArrayList<>();
        usedOnLevel.add(beginWord);

        List<List<String>> res=new ArrayList<>();

        //iterate in queue
        while(!q.isEmpty()){
            List<String> vec=q.poll();
            //erase all el of prev level from set
            if(vec.size()>level){
                level++;

                for(String it: usedOnLevel){
                    set.remove(it);
                }
            }

            String word=vec.get(vec.size()-1);

            if(word.equals(endWord)){
                //first sequence found
                if(res.size()==0) res.add(vec);
                else if (res.get(0).size() == vec.size()) res.add(vec);
            }

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char []replacedCharArray = word.toCharArray();
                    replacedCharArray[i]=ch;

                    String replacedWord=new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        vec.add(replacedWord);

                        List<String> temp= new ArrayList<>(vec);
                        q.add(temp);
                        //mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return res;
    }
}
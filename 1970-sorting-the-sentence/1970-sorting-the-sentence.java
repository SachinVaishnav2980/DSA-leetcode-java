class Solution {
    public String sortSentence(String s) {
        String []arr=s.split(" ");
        String []res=new String[arr.length];
        for(int i=0;i<arr.length;i++){
            String word=arr[i];
            int pos=word.charAt(word.length()-1)-'0';
            res[pos-1]=word.substring(0, word.length()-1);
        }
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<res.length;i++){
            s1.append(res[i]);
            if(i!=res.length-1) s1.append(" ");
        }
        return s1.toString();
    }
}
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder next=new StringBuilder();
        int i=s.length()-1;
        int nums=0;
        while (i>=0) {
            char ch=s.charAt(i);
            if(ch=='#'){
                nums=(s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
                next.append((char)('a'+(nums-1)));
                i=i-3;
            }else{
                nums=ch-'0';
                next.append((char)('a'+(nums-1)));
                i--;
            }
        }
        return next.reverse().toString();
    }
}
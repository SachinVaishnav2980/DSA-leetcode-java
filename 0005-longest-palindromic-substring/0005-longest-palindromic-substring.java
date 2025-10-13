class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            int []odd=expand(s, i,i);
            int []even=expand(s, i, i+1);

            int []longer=(odd[1]-odd[0]>even[1]-even[0])?odd:even;

            if(longer[1]-longer[0]>end-start){
                start=longer[0];
                end=longer[1];
            }
        }   
        return s.substring(start, end+1);
    }

    int []expand(String s, int left, int right){
        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return new int[]{left+1, right-1};
    }
}
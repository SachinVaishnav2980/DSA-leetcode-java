class Solution {
    public String breakPalindrome(String palindrome) {
        int n=palindrome.length();
        if(n==1) return "";
        StringBuilder str=new StringBuilder(palindrome);

        for(int i=0;i<n/2;i++){
            char ch=str.charAt(i);

            if(ch!='a'){
                str.setCharAt(i, 'a');
                return str.toString();
            }
        }

        str.setCharAt(n-1, 'b');
        return str.toString();
    }
}
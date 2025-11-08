class Solution {
    public static boolean isPalindrome(String s) {
        String str=s.toLowerCase();
        StringBuilder string=new StringBuilder();
        for(char ch:str.toCharArray()){
            if(!Character.isLetterOrDigit(ch)){
                continue;
            }else{
                string.append(ch);
            }
        }
        int i=0;
        int j=string.length()-1;
        while(i<=j){
            if(string.charAt(i)!=string.charAt(j)){
                return false;
            }    
            i++;
            j--;
        }
        return true;
    }
}
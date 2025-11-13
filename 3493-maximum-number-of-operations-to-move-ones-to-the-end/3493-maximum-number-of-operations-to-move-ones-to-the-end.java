class Solution {
    public int maxOperations(String s) {
        int zeros=0;
        int res=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='0'){
                if(i==s.length()-1 || s.charAt(i+1)=='1'){
                    zeros++;
                }
            }else{
                res+=zeros;
            }
        }
        return res;
    }
}
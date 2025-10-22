class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder ans=new StringBuilder();
        String curr=strs[0];
        for(int i=0;i<curr.length();i++){
            char ch=curr.charAt(i);
            for(int j=1;j<strs.length;j++){
                String str=strs[j];
                if(i>=str.length() || ch!=str.charAt(i)){
                    return ans.toString();
                }
            }
            ans.append(ch);
        }
        return ans.toString();
    }
}
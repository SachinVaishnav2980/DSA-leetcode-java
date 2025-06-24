class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder next=new StringBuilder();
        int depth=0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                if(depth>0){
                    next.append(ch);
                }
                depth++;
            }else{
                depth--;
                if(depth>0){
                    next.append(ch);
                }
            }
        }
        return next.toString();
    }
}
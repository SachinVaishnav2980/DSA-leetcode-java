class Solution {
    public String interpret(String command) {
        StringBuilder next=new StringBuilder(command.length());
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='G'){
                next.append('G');
            }
            if(command.charAt(i)=='('){
                if(command.charAt(i+1)==')'){
                    next.append('o');
                    i++;
                }else{
                next.append("al");
                i+=3;
            }
            }
        }
        return next.toString();
    }
}
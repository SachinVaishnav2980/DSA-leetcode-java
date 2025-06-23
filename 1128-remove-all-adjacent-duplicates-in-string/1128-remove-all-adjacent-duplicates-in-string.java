class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        while(!s.isEmpty()){
            char ch=s.charAt(0);
            if(stack.isEmpty() || ch!=stack.peek()){
                stack.push(ch);
            }else{
                stack.pop();
            }
            s=s.substring(1);
        }
        StringBuilder next=new StringBuilder();
        while (!stack.isEmpty()) {
            next.append(stack.pop());
        }
        next.reverse();
        return next.toString();
    }
}
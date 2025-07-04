class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (char element : num.toCharArray()) {

            while (!stack.isEmpty() && k > 0 && (element - '0') < (stack.peek())) {
                stack.pop();
                k = k - 1;
            }
            stack.push(element - '0');
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k = k - 1;
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        str.reverse();
        while(str.length()>0 && str.charAt(0)-'0'==0){
            str.deleteCharAt(0);
        }
        if(str.length()==0){
            return "0";
        }
        return str.toString();
    }
}
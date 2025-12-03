class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                st.push(ch);
            } else { // ch == ']'
                if (!st.isEmpty() && st.peek() == '[') {
                    st.pop(); // matched pair, remove
                } else {
                    st.push(ch); // unmatched closing bracket
                }
            }
        }
        int unmatched =0;
        while(!st.isEmpty()){
            if(st.pop()=='[') unmatched++;
        } // will be even
        return (unmatched + 1) / 2;
    }
}
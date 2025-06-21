class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        int start = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                reverse(sb, start, i - 1);
                start = i + 1;
            }
        }
        reverse(sb, start, sb.length() - 1);
        return sb.toString();
    }
    private void reverse(StringBuilder s, int i, int j) {
        while (i < j) {
            char temp = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, temp);
            i++;
            j--;
        }
    }
}
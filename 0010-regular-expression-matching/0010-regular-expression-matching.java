class Solution {
    public boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();
        return match(s, p, 0, 0, n1, n2);
    }

    boolean match(String s, String p, int i, int j, int n1, int n2){
        if(i>=n1 && j>=n2) return true;

        if(j>=n2) return false;

        boolean match=i<n1 && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');

        if(j+1<n2 && p.charAt(j+1)=='*'){
            return match(s, p, i, j+2, n1, n2) || (match && match(s, p, i+1, j, n1, n2));
        }

        if(match) return match(s, p, i+1, j+1, n1, n2);

        return false;

    }
}
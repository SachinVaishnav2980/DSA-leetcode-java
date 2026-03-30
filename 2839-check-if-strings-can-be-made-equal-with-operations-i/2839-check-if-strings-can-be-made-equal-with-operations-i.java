class Solution {
    public boolean canBeEqual(String s1, String s2) {
        return helper(new StringBuilder(s1), new StringBuilder(s2));
    }


    boolean helper(StringBuilder s1, StringBuilder s2){
        int n=s1.length();

        for(int i=0;i<n;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                int j=i+2;

                if(j<n && s1.charAt(j)==s2.charAt(i)){
                    swap(s1, i, j);
                }
            }
        }
        return s1.toString().equals(s2.toString());
    }

    private void swap(StringBuilder s1, int i, int j){
        char ch=s1.charAt(i);
        s1.setCharAt(i, s1.charAt(j));
        s1.setCharAt(j,ch);
    }
}
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String next1=String.join("",word1);
        String next2=String.join("",word2);
        if(next1.equals(next2)) return true;
        return false;
    }
}
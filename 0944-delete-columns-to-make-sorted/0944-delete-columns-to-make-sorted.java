class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        if(n==1) return 0;
        int m=strs[0].length();
        int col=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j+1<n && strs[j].charAt(i)-'a'>strs[j+1].charAt(i)-'a'){
                    col++;
                    break;
                }
            }
        }
        return col;
    }
}
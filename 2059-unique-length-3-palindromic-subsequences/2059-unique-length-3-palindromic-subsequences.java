class Solution {
    public int countPalindromicSubsequence(String s) {
        int []firstOc=new int[26];
        int []lastOc=new int[26];
        int n=s.length();
        Arrays.fill(firstOc, -1);
        Arrays.fill(lastOc, -1);

        
        //Store occurences
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int indx=ch-'a';

            if(firstOc[indx]==-1) firstOc[indx]=i;
            lastOc[indx]=i;
        }

        int uniquePalindrome=0;

        for(int i=0;i<26;i++){
            int initial=firstOc[i];
            int finalx=lastOc[i];

            if (initial == -1 || finalx == -1 || initial >= finalx) continue;

            Set<Character> set=new HashSet<>();
            int j=initial+1;
            while(j<=finalx-1){
                set.add(s.charAt(j));
                j++;
            }
            uniquePalindrome+=set.size();
        }
        return uniquePalindrome;
    }
}
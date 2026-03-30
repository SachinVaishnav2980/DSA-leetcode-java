class Solution {
    public boolean checkStrings(String s1, String s2) {
        return helper(new StringBuilder(s1), new StringBuilder(s2));
    }

    private boolean helper(StringBuilder s1, StringBuilder s2){
        int n=s1.length();

        char []even1=new char[(n+1)/2];
        char []even2=new char [(n+1)/2];
        char []odd1=new char [n/2];
        char []odd2=new char [n/2];

        int E=0; 
        int O=0;

        for(int i=0;i<n;i++){
            if(i%2==0){
                even1[E]=s1.charAt(i);
                even2[E]=s2.charAt(i);
                E++;
            }else{
                odd1[O]=s1.charAt(i);
                odd2[O]=s2.charAt(i);
                O++;
            }
        }

        Arrays.sort(even1);
        Arrays.sort(even2);
        Arrays.sort(odd1);
        Arrays.sort(odd2);
        
        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);
    }
}
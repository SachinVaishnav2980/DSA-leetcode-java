class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int mid=(s.length-1)/2;
        while(i<=mid){
            int j=s.length-1-i;
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
        }
        System.out.println(Arrays.toString(s));
    }
}
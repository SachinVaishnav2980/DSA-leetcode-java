class Solution {
    public void reverseString(char[] s) {
        reverse(s, 0);
    }

    public static void reverse(char []s, int index){
        int mid=(s.length-1)/2;
        if(index>mid){
            System.out.println(Arrays.toString(s));
            return;
        }
        int j=s.length-1-index;
        char temp=s[index];
        s[index]=s[j];
        s[j]=temp;
        reverse(s, index+1);
    }
}
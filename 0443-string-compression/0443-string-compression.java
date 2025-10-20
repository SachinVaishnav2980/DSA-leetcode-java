class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        int read=0;  //for reading all the characters 
        int write=0; // for writing the character and count of same character

        while (read<n) {
            char curr=chars[read];
            int count=0;
            while (read<n && curr==chars[read]) {
                read++;
                count++;
            }

            chars[write++]=curr;

            if(count>1){
                String num=String.valueOf(count);
                for(char ch:num.toCharArray()){
                    chars[write++]=ch;
                }
            }
        }
       return write;
    }
}
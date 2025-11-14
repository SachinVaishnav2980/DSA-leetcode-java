class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int []nums=new int [n];

        //building the array;
        for(int []q:shifts){
            int left=q[0];
            int right=q[1];
            int dir=q[2];

            if(dir==1){
                nums[left]+=1;
                if(right+1<n){
                    nums[right+1]-=1;
                }
            }else{
                nums[left]-=1;
                if(right+1<n){
                    nums[right+1]+=1;
                }
            }
        }
        //prefix sum
        for(int i=1;i<n;i++){
            nums[i]=nums[i-1]+nums[i];
        }
        //Now finding the answer
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            int totalShift = ((nums[i] % 26) + 26) % 26; //negative value handling
            int original=s.charAt(i)-'a';
            original=(original+totalShift+26)%26;
            str.append((char)(original + 'a'));
        }
        return str.toString();
    }
}
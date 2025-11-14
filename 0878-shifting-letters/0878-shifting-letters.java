class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char []arr=s.toCharArray();
        int n=s.length();
        int totalShift=0;
        for(int i=n-1;i>=0;i--){
            int originalChar=arr[i]-'a';
            totalShift=(totalShift+shifts[i])%26;
            int shifted=(originalChar+totalShift)%26;
            char ch=(char)(shifted+'a');
            arr[i]=ch;
        }
        return new String(arr);
    }
}
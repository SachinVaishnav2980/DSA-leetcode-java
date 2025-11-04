class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int num2=0;
        int num3=x;
        while(num3>0){
            int digit=num3%10;
            num2=num2*10+digit;
            num3=num3/10;
        }
        return num2==x;
    }
}
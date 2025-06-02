class Solution {
    char ans = 'a';
    public String reverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1 ;i>= 0;i--){
            sb.append(str.charAt(i) == '0' ? 1:0);
        }
        return sb.toString();
    }
    public void operation(int n, String str , int k ){
        if(n == 1) {
        ans = str.charAt(k-1);
        return;
        }
        String newstr = reverse(str);
        operation(n-1 , str+"1"+newstr , k);
    }
    public char findKthBit(int n, int k) {
        operation(n, "0", k);
        return ans;
    }
}
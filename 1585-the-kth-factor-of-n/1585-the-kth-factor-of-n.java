class Solution {
    public int kthFactor(int n, int k) {
        int tak = (n/2)+1;
        int count = 0;
        for(int i=1 ;i<=tak; i++){
            if(n%i==0){
                count++;
                if(count==k){
                    return i;
                }
            }
        }
        count++;
        if(count==k){
            return n;
        }
       return -1;
    }
}
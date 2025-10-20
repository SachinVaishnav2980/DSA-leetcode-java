class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String element:operations){
            for(char ch:element.toCharArray()){
                if(ch!='X'){
                    if(ch=='+'){
                        x+=1;
                    }else{
                        x-=1;
                    }
                    break;
                }
            }
        }
        return x;
    }
}
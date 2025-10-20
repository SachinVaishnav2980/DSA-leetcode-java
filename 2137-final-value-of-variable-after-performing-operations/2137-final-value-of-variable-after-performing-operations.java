class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String element:operations){
            if(element.contains("+")){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
}
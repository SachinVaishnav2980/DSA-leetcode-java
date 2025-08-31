class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots=1;
        String []arr=preorder.split(",");
        for(String str:arr){
            slots--;
            if(slots<0){
                return false;
            }
            if(!str.equals("#")){
                slots+=2;
            }
        }
        return slots==0;
    }
}
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        int twenty=0;
        for(int bill:bills){
            if(bill==5){
                five++;
            }else if(bill==10){
                ten++;
                if(five!=0){
                    five--;
                }else return false;
            }else{
                twenty++;
                if(five==0) return false;
                else{
                    if(ten==0){
                        if(five<3){
                            return false;
                        }else{
                            five-=3;
                        }
                    }else{
                        five--;
                        ten--;
                    }
                }
            }
        }
        return true;
    }
}
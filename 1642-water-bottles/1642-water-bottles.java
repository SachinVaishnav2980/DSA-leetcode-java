class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottle=0;
        int drunkBottle=0;
        drunkBottle=emptyBottle=numBottles;
        numBottles=0;
        while(emptyBottle>=numExchange){
            emptyBottle-=numExchange;
            numBottles++;
            if(emptyBottle<numExchange && numBottles!=0){
                drunkBottle+=numBottles;
                emptyBottle+=numBottles;
                numBottles=0;
            }
        }
        return drunkBottle;
    }
}
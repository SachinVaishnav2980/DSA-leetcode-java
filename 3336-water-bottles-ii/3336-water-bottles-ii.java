class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottle=0;
        int bottleDrunk=0;
        emptyBottle=bottleDrunk=numBottles;
        numBottles=0;
        while(emptyBottle>=numExchange){
            emptyBottle-=numExchange;
            numExchange++;
            numBottles++;
            if(emptyBottle<numExchange &&  numBottles!=0){
                emptyBottle+=numBottles;
                bottleDrunk+=numBottles;
                numBottles=0;
            }
        }
        return bottleDrunk;
    }
}
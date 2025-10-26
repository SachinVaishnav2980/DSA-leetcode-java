class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice=Integer.MIN_VALUE;
        int prevBuy=prices[0];

        for(int i=1;i<prices.length;i++){
            if(prices[i]>prevBuy){
                maxPrice=Math.max(maxPrice, prices[i]-prevBuy);
            }
            prevBuy=Math.min(prevBuy, prices[i]);
        }
        if(maxPrice<0) return 0;
        else return maxPrice;
    }
}
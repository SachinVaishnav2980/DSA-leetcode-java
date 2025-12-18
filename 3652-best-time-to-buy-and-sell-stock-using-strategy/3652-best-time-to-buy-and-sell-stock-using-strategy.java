class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) prices[i] * strategy[i];
        }

        long maxProfit = baseProfit;
        long currProfit = baseProfit;

        int half = k / 2;

        // apply first window
        for (int i = 0; i < k; i++) {
            int newVal = (i < half) ? 0 : 1;
            currProfit += (long) prices[i] * (newVal - strategy[i]);
        }
        maxProfit = Math.max(maxProfit, currProfit);

        // slide window
        for (int start = 1; start + k <= n; start++) {
            int prevLeft = start - 1;
            int prevMid = start - 1 + half;
            int newRight = start + k - 1;

            // restore outgoing left
            currProfit += (long) prices[prevLeft] * (strategy[prevLeft] - 0);

            // middle element flips from 1 → 0
            currProfit += (long) prices[prevMid] * (0 - 1);

            // new right becomes 1
            currProfit += (long) prices[newRight] * (1 - strategy[newRight]);

            maxProfit = Math.max(maxProfit, currProfit);
        }

        return maxProfit;
    }
}

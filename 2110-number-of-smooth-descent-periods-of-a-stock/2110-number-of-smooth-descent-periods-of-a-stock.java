class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (right > 0 && prices[right] != prices[right - 1] - 1) {
                left = right;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
class Solution {
    public int specialTriplets(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;
        long triplet = 0L;

        Map<Long, Integer> left = new HashMap<>();
        Map<Long, Integer> right = new HashMap<>();

        // Store everything in right map (use Long keys to safely hold doubled values)
        for (int i = 0; i < n; i++) {
            long v = nums[i];
            right.put(v, right.getOrDefault(v, 0) + 1);
        }

        for (int x : nums) {
            long v = x;

            // decrement right count for v
            int curRight = right.getOrDefault(v, 0) - 1;
            if (curRight <= 0) right.remove(v);
            else right.put(v, curRight);

            long need = v * 2L;
            long freqPrev = left.getOrDefault(need, 0);
            long freqNext = right.getOrDefault(need, 0);

            // add (freqPrev * freqNext) to answer (modded)
            triplet = (triplet + (freqPrev * freqNext) % MOD) % MOD;

            // move current v into left
            left.put(v, left.getOrDefault(v, 0) + 1);
        }

        return (int) (triplet % MOD);
    }
}
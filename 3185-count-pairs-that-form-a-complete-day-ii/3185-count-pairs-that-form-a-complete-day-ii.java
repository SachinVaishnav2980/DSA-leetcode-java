class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Long> map = new HashMap<>();
        long count = 0;

        for (int h : hours) {
            int r = h % 24;
            int target = (24 - r) % 24;

            count += map.getOrDefault(target, 0L);

            map.put(r, map.getOrDefault(r, 0L) + 1);
        }

        return count;
    }
}
class Solution {
    class Pair<F, S> {
        F first;
        S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> queue = new PriorityQueue<>((a, b) -> a.first - b.first);
        int n = nums.size();
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            queue.add(new Pair<>(nums.get(i).get(0), new Pair<>(i, 0)));
            maximum = Math.max(maximum, nums.get(i).get(0));

        }

        minimum = queue.peek().first;
        int[] arr = new int[2];
        arr[0] = minimum;
arr[1] = maximum;

        int row;
        int col;
        Pair<Integer, Pair<Integer, Integer>> temp;
        int element;

        while (queue.size() == nums.size()) {
            temp = queue.poll();
            element = temp.first;
            row = temp.second.first;
            col = temp.second.second;

            if (col + 1 < nums.get(row).size()) {
                col++;
                queue.add(new Pair<>(nums.get(row).get(col)
, new Pair<>(row, col)));
                maximum = Math.max(maximum, nums.get(row).get(col)
                );
                minimum = queue.peek().first;
            }

            if (maximum - minimum < arr[1] - arr[0]) {
                arr[0] = minimum;
                arr[1] = maximum;
            }
        }
        return arr;
    }
}
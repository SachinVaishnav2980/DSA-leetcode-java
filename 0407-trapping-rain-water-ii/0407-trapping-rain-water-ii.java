class Solution {
    class Pair<F, S> {
    F first;
    S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
}
    private static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;

        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> pq =
                new PriorityQueue<>((a, b) -> a.first - b.first);

        // push all border cells into heap
        for (int i = 0; i < n; i++) {
            pq.add(new Pair<>(heightMap[i][0], new Pair<>(i, 0)));
            pq.add(new Pair<>(heightMap[i][m-1], new Pair<>(i, m-1)));
            visited[i][0] = true;
            visited[i][m-1] = true;
        }
        for (int j = 1; j < m-1; j++) {
            pq.add(new Pair<>(heightMap[0][j], new Pair<>(0, j)));
            pq.add(new Pair<>(heightMap[n-1][j], new Pair<>(n-1, j)));
            visited[0][j] = true;
            visited[n-1][j] = true;
        }

        int water = 0;
        int level = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Pair<Integer, Integer>> cell = pq.poll();
            int h = cell.first;
            int i = cell.second.first;
            int j = cell.second.second;

            level = Math.max(level, h);

            // explore 4 neighbors
            for (int[] d : DIRS) {
                int ni = i + d[0], nj = j + d[1];
                if (isValid(ni, nj, n, m) && !visited[ni][nj]) {
                    visited[ni][nj] = true;

                    int neighbour = heightMap[ni][nj];
                    if (neighbour < level) {
                        water += level - neighbour;
                    }

                    pq.add(new Pair<>(Math.max(neighbour, level), new Pair<>(ni, nj)));
                }
            }
        }
        return water;
    }

    private boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }
}
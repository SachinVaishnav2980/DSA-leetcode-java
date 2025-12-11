class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        // Initialize min/max arrays
        int INF = (int)1e9;

        int[] minY = new int[n + 1];
        int[] maxY = new int[n + 1];
        int[] minX = new int[n + 1];
        int[] maxX = new int[n + 1];

        // Fill initial values
        for (int i = 0; i <= n; i++) {
            minY[i] = INF;
            minX[i] = INF;
            maxY[i] = -INF;
            maxX[i] = -INF;
        }

        // First pass: compute min/max for each row (x) and column (y)
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            minY[x] = Math.min(minY[x], y);
            maxY[x] = Math.max(maxY[x], y);

            minX[y] = Math.min(minX[y], x);
            maxX[y] = Math.max(maxX[y], x);
        }

        int covered = 0;

        // Second pass: check coverage condition
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            if (minY[x] < y && y < maxY[x] &&   // Has at least one to the left and right
                minX[y] < x && x < maxX[y]) {   // Has at least one above and below
                covered++;
            }
        }

        return covered;
    }
}

class Robo {
    int pos, range;

    Robo(int pos, int range) {
        this.pos = pos;
        this.range = range;
    }
}

class Solution {

    private int[][] dp;

    public int maxWalls(int[] robots, int[] distance, int[] walls) {

        int n = robots.length;

        // Build robot objects
        Robo[] robos = new Robo[n];
        for (int i = 0; i < n; i++) {
            robos[i] = new Robo(robots[i], distance[i]);
        }

        // Sort robots & walls
        Arrays.sort(robos, (a, b) -> a.pos - b.pos);
        Arrays.sort(walls);

        // DP initialization
        dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, robos, walls);
    }

    private int solve(int idx, int prevDir, Robo[] robos, int[] walls) {

        if (idx == robos.length) return 0;

        if (dp[idx][prevDir] != -1) return dp[idx][prevDir];

        Robo curr = robos[idx];

        // -------------------------
        // OPTION 1: Go LEFT
        // -------------------------
        int leftBound = Math.max(0, curr.pos - curr.range);

        if (idx > 0) {
            if (prevDir == 0) {
                leftBound = Math.max(leftBound, robos[idx - 1].pos + 1);
            } else {
                leftBound = Math.max(leftBound, robos[idx - 1].pos + robos[idx - 1].range + 1);
            }
        }

        int leftWalls = countWalls(leftBound, curr.pos, walls);
        int optionLeft = leftWalls + solve(idx + 1, 0, robos, walls);

        // -------------------------
        // OPTION 2: Go RIGHT
        // -------------------------
        int rightBound = curr.pos + curr.range;

        if (idx < robos.length - 1) {
            rightBound = Math.min(rightBound, robos[idx + 1].pos - 1);
        }

        int rightWalls = countWalls(curr.pos, rightBound, walls);
        int optionRight = rightWalls + solve(idx + 1, 1, robos, walls);

        return dp[idx][prevDir] = Math.max(optionLeft, optionRight);
    }

    // Counts walls in [lb, rb] using binary search
    private int countWalls(int lb, int rb, int[] walls) {

        int leftIdx = lowerBound(walls, lb);
        int rightIdx = upperBound(walls, rb);

        if (leftIdx == -1 || rightIdx == -1 || leftIdx > rightIdx) return 0;

        return rightIdx - leftIdx + 1;
    }

    // First index >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    // Last index <= target
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}

class Solution {
    int MOD = 1000000007;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[][] memo = new int[n][2];

        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            count = (count + solve(arr, i, 0, memo)) % MOD;
        }

        return count;
    }

    int solve(int[] arr, int idx, int parity, int[][] memo) {

        if (idx == arr.length) return 0;

        if (memo[idx][parity] != -1) {
            return memo[idx][parity];
        }

        int newParity = (parity + arr[idx] % 2 + 2) % 2;

        int count = newParity == 1 ? 1 : 0;

        count = (count + solve(arr, idx + 1, newParity, memo)) % MOD;

        return memo[idx][parity] = count;
    }
}

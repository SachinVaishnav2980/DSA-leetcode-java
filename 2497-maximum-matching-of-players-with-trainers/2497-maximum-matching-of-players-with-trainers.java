class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int left = 0;
        int right = 0;

        while (left < trainers.length) {
            if (right < players.length) {
                if (players[right] <= trainers[left]) {
                    right++;
                }
            }
            left++;
        }
        return right;
    }
}
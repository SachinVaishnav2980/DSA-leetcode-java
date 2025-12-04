class Solution {
    //Two pointer approach
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0;
        // skip leading 'L' cars (they never collide)
        while (i < n && directions.charAt(i) == 'L') i++;

        int j = n - 1;
        
        // skip trailing 'R' cars (they never collide)
        while (j >= 0 && directions.charAt(j) == 'R') j--;

        if (i > j) return 0; // crossed
        int collisions = 0;
        for (int k = i; k <= j; k++) {
            if (directions.charAt(k) != 'S') collisions++;
        }
        return collisions;
    }
}
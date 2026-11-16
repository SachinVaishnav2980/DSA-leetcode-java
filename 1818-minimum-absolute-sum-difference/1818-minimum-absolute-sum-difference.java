
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += Math.abs((long)nums1[i] - nums2[i]);
        }

        int[] arr = nums1.clone();
        Arrays.sort(arr);

        long maxImprovement = 0;

        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;

            long originalDiff =
                Math.abs((long)nums1[i] - nums2[i]);

            // Find lower bound
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (arr[mid] < nums2[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // Check element at lower bound
            if (low < n) {
                long newDiff =
                    Math.abs((long)arr[low] - nums2[i]);

                maxImprovement = Math.max(
                    maxImprovement, originalDiff - newDiff
                );
            }

            // Check element before lower bound
            if (low > 0) {
                long newDiff =
                    Math.abs((long)arr[low - 1] - nums2[i]);

                maxImprovement = Math.max(
                    maxImprovement, originalDiff - newDiff
                );
            }
        }

        return (int)((totalSum - maxImprovement) % 1000000007);
    }
}

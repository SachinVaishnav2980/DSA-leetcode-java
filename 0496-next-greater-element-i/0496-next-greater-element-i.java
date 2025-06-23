class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        ArrayList<Integer> ans = new ArrayList<>();
        int val = 0;
        for (int i = 0; i < nums1.length; i++) {
            int element = nums1[i];
            val = findElement(nums1, nums2, element);
            ans.add(val);
        }
        for (int i = 0; i < ans.size(); i++) {
            nums1[i] = ans.get(i);
        }
        return nums1;
    }

    public int findElement(int[] nums1, int[] nums2, int element) {
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == element) {
                int j = i + 1;
                while (j < nums2.length) {
                    if (nums2[j]>nums2[i]){
                        return nums2[j];
                    }j++;
                }
            }
        }
        return -1;
    }
}
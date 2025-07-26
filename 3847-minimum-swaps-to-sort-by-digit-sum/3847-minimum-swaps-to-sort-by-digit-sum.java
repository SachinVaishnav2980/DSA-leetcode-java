class Solution {
    private int digitSum(int n) {
        int res = 0;
        while (n != 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    public int minSwaps(int[] nums) {
        HashMap<Integer, Integer> pos = new HashMap<>();
        HashMap<Integer, Integer> num = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            num.put(nums[i], i);
            pos.put(i, nums[i]);
        }

        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);
            if(sumA == sumB) return a - b;
            return sumA - sumB; 
        });

        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            int newPos = i;
            int iniPos = num.get(arr[i]);
            if (iniPos != newPos) {
                int temp = pos.get(newPos);

                num.put(arr[i], newPos);
                num.put(temp, iniPos);

                pos.put(newPos, arr[i]);
                pos.put(iniPos, temp);
                swaps++;
            }
        }
        return swaps;
    }
}
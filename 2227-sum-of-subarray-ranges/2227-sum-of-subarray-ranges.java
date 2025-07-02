class Solution {
    public long subArrayRanges(int[] nums) {
            return sumSubarrayMax(nums)-sumSubarrayMins(nums);
        }

        // SubArray minimum
        public long sumSubarrayMins(int []nums){
            int []nse=new int[nums.length];
            int []psee=new int[nums.length];
            long total=0;
            nse(nums, nse);
            psee(nums, psee);
            for(int i=0;i<nums.length;i++){
                int left=i-psee[i];
                int right=nse[i]-i;
                total += 1L * left * right * nums[i];
            }
            return total;
        }

        public int [] nse(int []nums, int []nse){
            Stack<Integer> stack=new Stack<>();
            for(int i=nums.length-1;i>=0;i--){
                while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]) {
                    stack.pop();
                }
                nse[i]=stack.isEmpty()?nums.length:stack.peek();
                stack.push(i);
            }
            return nse;
        }

        public int [] psee(int []nums, int []psee){
            Stack<Integer> stack=new Stack<>();
            for(int i=0;i<nums.length;i++){
                while (!stack.isEmpty() && nums[stack.peek()]>nums[i]) {
                    stack.pop();
                }
                psee[i]=stack.isEmpty()?-1:stack.peek();
                stack.push(i);
            }
            return psee;
        }


        //SubArray maximum
        public long sumSubarrayMax(int []nums){
            int []nge=new int[nums.length];
            int []pgee=new int[nums.length];
            long total=0;
            nge(nums, nge);
            pgee(nums, pgee);
            for(int i=0;i<nums.length;i++){
                int left = i - pgee[i];
                int right = nge[i] - i;
                total += 1L * left * right * nums[i];
            }
            return total;
        }

        public int [] nge(int []nums, int []nse){
            Stack<Integer> stack=new Stack<>();
            for(int i=nums.length-1;i>=0;i--){
                while (!stack.isEmpty() && nums[i]>=nums[stack.peek()]) {
                    stack.pop();
                }
                nse[i]=stack.isEmpty()?nums.length:stack.peek();
                stack.push(i);
            }
            return nse;
        }

        public int [] pgee(int []nums, int []psee){
            Stack<Integer> stack=new Stack<>();
            for(int i=0;i<nums.length;i++){
                while (!stack.isEmpty() && nums[i]>nums[stack.peek()]) {
                    stack.pop();
                }
                psee[i]=stack.isEmpty()?-1:stack.peek();
                stack.push(i);
            }
            return psee;
        }
}
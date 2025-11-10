class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int op=0;
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && nums[i]<stack.peek()){
                stack.pop();
            }

            if(nums[i]==0){
                continue;
            }

            if(stack.isEmpty() || stack.peek()<nums[i]){
                op++;
                stack.push(nums[i]);
            }
        }
        return op;
    }
}
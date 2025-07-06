class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        Deque<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty() && queue.getFirst()<=i-k){
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[i]>=nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.addLast(i);
            if(i>=k-1) list.add(nums[queue.peekFirst()]);
        }
        int []ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}
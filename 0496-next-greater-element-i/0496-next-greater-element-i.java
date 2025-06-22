class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer, Integer> nextGreater= new HashMap();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[i]>stack.peek()){
                int smaller=stack.pop();
                nextGreater.put(smaller, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int []result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i]=nextGreater.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
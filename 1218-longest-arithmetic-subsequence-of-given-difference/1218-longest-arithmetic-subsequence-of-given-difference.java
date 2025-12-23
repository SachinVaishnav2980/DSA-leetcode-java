class Solution {
    //Hashing- Optimised
    public int longestSubsequence(int[] arr, int diff) {
        int result=0;
        int n=arr.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int prev=arr[i]-diff;
            int curr_len=map.getOrDefault(prev, 0);
            map.put(arr[i], curr_len+1);
            result=Math.max(result, map.get(arr[i]));
        }
        return result;
    }
}
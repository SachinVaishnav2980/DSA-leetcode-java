class Solution {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        Set<Integer> set=new HashSet<>();
        if(n1<=n2){
            for(int i=0;i<n1;i++){
                for(int j=0;j<n2;j++){
                    if(nums1[i]==nums2[j] && !set.contains(nums1[i])){
                        set.add(nums1[i]);
                    }
                }
            }
        }else{
            for(int i=0;i<n2;i++){
                for(int j=0;j<n1;j++){
                    if(nums2[i]==nums1[j] && !set.contains(nums2[i])){
                        set.add(nums2[i]);
                    }
                }
            }
        }

        int []ans=new int[set.size()];
        int i=0;
        for(int element:set){
            ans[i++]=element;
    }
    return ans;
}
}
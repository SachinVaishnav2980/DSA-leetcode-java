class KthLargest {
        int k;
        List<Integer> list;        

    public KthLargest(int k, int[] nums) {
        this.k=k;
        list=new ArrayList<>();
        for(int element:nums){
            list.add(element);
        }
    }
    
    public int add(int val) {

        list.add(val);
        Collections.sort(list);
        int n=list.size();
        return list.get(n-k);
    }
} 

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
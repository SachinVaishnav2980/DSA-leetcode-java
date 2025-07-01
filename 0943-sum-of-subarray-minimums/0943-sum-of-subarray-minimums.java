class Solution {
   public int sumSubarrayMins(int[] arr) {
        int mod=(int)(Math.pow(10,9)+7);
        int []nse=new int[arr.length];
        nse(arr, nse);
        int []psee=new int [arr.length];
        psee(arr, psee);
        int total=0;
        for(int i=0;i<arr.length;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(int)((total+(1l*left*right%mod*arr[i]%mod))%mod);
        }
        return total;
    }

    public int [] nse(int []arr, int []nse){
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            nse[i]=stack.isEmpty()?arr.length:stack.peek();
            stack.push(i);
        }
        return nse;
    }

    public int[] psee(int []arr, int []psee){
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            psee[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return psee;
    }
}
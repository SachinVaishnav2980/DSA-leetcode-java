class Solution {
    public int maximalRectangle(char[][] matrix) {
        int [][]prefixSum=new int[matrix.length][matrix[0].length];
        int sum=0;
        for(int col=0;col<matrix[0].length;col++){
            for(int row=0;row<matrix.length;row++){
                sum+=matrix[row][col]-'0';
                if(matrix[row][col]=='0'){
                    sum=0;
                }
                prefixSum[row][col]=sum;
            }
            sum=0;
        }
        int maxArea=0;
        for(int row=0;row<matrix.length;row++){
            maxArea=Math.max(maxArea, LargestAreaHistogram(prefixSum[row]));
        }
        return maxArea;
    }


    public int LargestAreaHistogram(int []nums){
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        int nse=0;
        int pse=0;
        int element=0;
        for(int i=0;i<nums.length;i++){
            while (!stack.isEmpty() && nums[stack.peek()]>nums[i]) {
                nse=i;
                element=stack.pop();
                pse=stack.isEmpty()?-1:stack.peek();
                maxArea=Math.max(maxArea, nums[element]*(nse-pse-1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            nse=nums.length;
            element=stack.pop();
            pse=stack.isEmpty()?-1:stack.peek();
            maxArea=Math.max(maxArea, nums[element]*(nse-pse-1));
        }
        return maxArea;
    }
}
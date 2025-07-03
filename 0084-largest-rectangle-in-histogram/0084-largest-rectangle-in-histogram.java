class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int nse=0;
        int pse=0;
        int element=0;
        int area=0;
        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                nse=i;
                element=stack.pop();
                pse=stack.isEmpty()?-1:stack.peek();
                area=Math.max(area, heights[element]*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
                nse=heights.length;
                element=stack.pop();
                pse=stack.isEmpty()?-1:stack.peek();
                area=Math.max(area, heights[element]*(nse-pse-1));
            }

        return area;
    }
}
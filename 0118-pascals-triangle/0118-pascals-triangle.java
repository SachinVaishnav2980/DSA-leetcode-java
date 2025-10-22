class Solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> outer=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            outer.add(rowGenerator(i));
        }
        return outer;
    }

    List<Integer> rowGenerator(int row){
        List<Integer> inner=new ArrayList<>();
        inner.add(1);
        int res=1;
        for(int col=1;col<row;col++){
            res=res*(row-col);
            res=res/col;
            inner.add(res);
        }
        return inner;
    }
}
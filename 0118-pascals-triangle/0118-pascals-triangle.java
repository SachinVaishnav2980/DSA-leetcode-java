class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outer=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            if(i==1){
                List<Integer> inner=new ArrayList<>();
                inner.add(1);
                outer.add(inner);
            }else if(i==2){
                List<Integer> inner=new ArrayList<>();
                inner.add(1);
                inner.add(1);
                outer.add(inner);
            }else{
                List<Integer> inner=new ArrayList<>();
                inner.add(1);
                List<Integer> prev=outer.get(outer.size()-1);
                for(int j=0;j<prev.size();j++){
                    if(j+1<prev.size()){
                        inner.add(prev.get(j)+prev.get(j+1));
                    }
                }
                inner.add(1);
                outer.add(inner);
            }
        }
        return outer;
    }
}
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)->Integer.compare(a[1], b[1]));
        List<int []> list=new ArrayList<>();
        list.add(pairs[0]);
        for(int i=1;i<pairs.length;i++){
            int []pair=list.get(list.size()-1);
            int start1=pair[0];
            int end1=pair[1];

            int start2=pairs[i][0];
            int end2=pairs[i][1];

            if(Math.max(start1, start2)<=Math.min(end1, end2)){
                continue;
            }else{
                list.add(pairs[i]);
            }
        }
        return list.size();
    }
}
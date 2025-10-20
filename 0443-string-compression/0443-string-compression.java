class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        List<Character> list=new ArrayList<>();
        int i=0;
        while (i<n) {
            char curr=chars[i];
            int count=0;
            while (i<n && curr==chars[i]) {
                i++;
                count++;
            }

            list.add(curr);

            if(count>1){
                String num=String.valueOf(count);
                for(char ch:num.toCharArray()){
                    list.add(ch);
                }
            }
        }
        for (int k = 0; k < list.size(); k++) {
            chars[k] = list.get(k);
        }
        return list.size();
    }
}
class Solution {
    char [][] letters={
        {},
        {},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w','x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        addCombinations(digits, 0, res, new StringBuilder());
        return res;
    }

    void addCombinations(String digits, int index, List<String> res, StringBuilder sb){
        //Base case
        if(index==digits.length()){
            res.add(sb.toString());
            return ;
        }

        int digit=digits.charAt(index)-'0';
        // recursive loop
        
        for(char ch : letters[digit]){
            sb.append(ch);
            addCombinations(digits, index+1, res, sb);
            sb.deleteCharAt(sb.length()-1);

        }
        return ;
    }
}
class Solution {
    public String smallestNumber(String pattern) {
        boolean []used=new boolean[10];
        StringBuilder sb=new StringBuilder();
        solve(used, pattern, sb);    
        return sb.toString();
    }

    private boolean solve(boolean []used, String pattern, StringBuilder ans){
        if(ans.length()==pattern.length()+1){
            return true;
        }

        for(int digit=1;digit<=9;digit++){

            if(used[digit]) continue;

            int len=ans.length();
            if(len>0){
                char ch=pattern.charAt(len-1);
                int prev=ans.charAt(len-1)-'0';

                if(ch=='I' && digit <= prev) continue;
                if(ch=='D' && digit >= prev) continue;
            }
            
            used[digit]=true;
            ans.append(digit);
            if(solve(used, pattern, ans)) return true;
            used[digit]=false;
            ans.deleteCharAt(ans.length()-1);
        }
        return false;
    }

}
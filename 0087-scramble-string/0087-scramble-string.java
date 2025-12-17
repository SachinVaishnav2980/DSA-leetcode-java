class Solution {
    Map<String, Boolean> map=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();

        if(n1!=n2) return false;
        return solve(s1, s2);
    }

    boolean solve(String a, String b){
        if(a.equals(b)) return true;

        if(a.length()<=1) return false;

        String key=a+" "+b;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int n=a.length();
        boolean flag=false;

        for(int i=1;i<n;i++){
            // Case 1: swap
            boolean swap =
                solve(a.substring(0, i), b.substring(n - i, n)) &&
                solve(a.substring(i, n), b.substring(0, n - i));

            // Case 2: no swap
            boolean noswap =
                solve(a.substring(0, i), b.substring(0, i)) &&
                solve(a.substring(i, n), b.substring(i, n));
            if(swap || noswap){
            flag=true;
            break;
        }
        }
        map.put(key,flag);
        return flag;
    }
}
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repitition=1;
        StringBuilder str=new StringBuilder(a);
        while (str.length()<b.length()) {
            str.append(a);
            repitition++;            
        }

        if(str.indexOf(b)!=-1) return repitition;
        str.append(a);
        repitition++;
        if(str.indexOf(b)!=-1) return repitition;

        return -1;
    }
}
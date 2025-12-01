class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n=people.length;
        int minBoats=0;
        int i=0;
        int j=n-1;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                minBoats++;
                i++;
                j--;
            }else{
                minBoats++;
                j--;
            }
        }
        return minBoats;
    }
}
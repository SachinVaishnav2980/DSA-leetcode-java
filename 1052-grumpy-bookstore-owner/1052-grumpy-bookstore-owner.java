class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;
        int currUn=0;
        int maxUnsatisfied=0;
        for(int i=0;i<minutes;i++){
            currUn+=customers[i]*grumpy[i];
        }
        maxUnsatisfied=currUn;
        //fixed size window
        int i=0;
        int j=minutes;
        while(j<n){
            //remove last person and add new person
            currUn += customers[j]*grumpy[j];
            currUn -= customers[i]*grumpy[i];
            
            maxUnsatisfied=Math.max(maxUnsatisfied, currUn);
            i++;
            j++;
        }

        //now calc remaining count;
        for(int k=0;k<n;k++){
            if(grumpy[k]==0){
                maxUnsatisfied+=customers[k];
            }
        }
        return maxUnsatisfied;
    }
}
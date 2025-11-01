class Solution {
    public int compareVersion(String version1, String version2) {
        String []arr1=version1.split("\\.");
        String []arr2=version2.split("\\.");
        int n1=arr1.length;
        int n2=arr2.length;
        int max=Math.max(arr1.length, arr2.length);
        
        for(int i=0;i<max;i++){
            int num1=(i<n1)?Integer.parseInt(arr1[i]):0;
            int num2=(i<n2)?Integer.parseInt(arr2[i]):0;

            if(num1<num2) return -1;
            else if (num1>num2) return 1;
        }
        return 0;
    }
}
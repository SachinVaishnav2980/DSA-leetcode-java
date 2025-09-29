class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i=floor(arr, x);
        int n=arr.length;
        int j=i+1;
        List<Integer> list=new ArrayList<>();
        while (k>0 && i>=0 && j<n){
            if(Math.abs(arr[i]-x)<=Math.abs(arr[j]-x)){
                list.add(arr[i]);
                i--;
            }else{
                list.add(arr[j]);
                j++;
            }
            k--;
        }
        while (k>0 && i>=0){
            list.add(arr[i--]);
            k--;
        }
        while (k>0 && j<n){
            list.add(arr[j++]);
            k--;
        }

        Collections.sort(list);
        return list;


    }

    int floor(int []arr, int x){
        if(arr.length==0){
            return -1;
        }
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]<x){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return end;
    }
}
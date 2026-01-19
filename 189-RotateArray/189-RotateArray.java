// Last updated: 1/19/2026, 10:49:25 PM
class Solution {
    public void rotate(int[] arr, int k) {
        k=k%arr.length;
        int n = arr.length;
        reverse(arr,arr.length-k,arr.length-1);
        reverse(arr,0,arr.length-1-k);
        reverse(arr,0,arr.length-1);
    }
    public void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
}
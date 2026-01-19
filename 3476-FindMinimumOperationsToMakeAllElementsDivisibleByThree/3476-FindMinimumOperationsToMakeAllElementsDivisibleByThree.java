// Last updated: 1/19/2026, 9:57:41 PM
class Solution {
    public int minimumOperations(int[] arr) {
        int min=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%3 !=0) min++;
        }
        return min;
    }
}
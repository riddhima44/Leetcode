// Last updated: 1/29/2026, 12:50:58 AM
1class Solution {
2    public int findKthPositive(int[] arr, int k) {
3        int ans=k;
4        for(int i=0;i<arr.length;i++){
5            if(arr[i]<=ans){
6                ans++;
7            }
8        }return ans;
9    }
10}
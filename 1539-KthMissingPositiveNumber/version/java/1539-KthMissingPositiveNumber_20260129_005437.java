// Last updated: 1/29/2026, 12:54:37 AM
1class Solution {
2    public int findKthPositive(int[] arr, int k) {
3        for(int i=0;i<arr.length;i++){
4            if(arr[i]<=k){
5                k++;
6            }
7            else{
8                break;
9            }
10        }
11        return k;
12    }
13}
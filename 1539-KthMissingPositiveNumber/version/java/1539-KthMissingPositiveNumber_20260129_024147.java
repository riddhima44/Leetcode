// Last updated: 1/29/2026, 2:41:47 AM
1class Solution {
2    public int findKthPositive(int[] arr, int k) {
3        int start=0;
4        int end=arr.length-1;
5        while(start<=end){
6            int mid = start+(end-start)/2;
7            int missing = arr[mid]-(mid+1);
8            if(missing<k){
9                start=mid+1;
10            }
11            else{
12                end=mid-1;
13            }
14        }
15        // int missing = arr[end]-(end+1);
16        // int more = k-missing;
17        // return arr[end]+more;
18        return end +1+k;
19        //return low+k; 
20    }
21}
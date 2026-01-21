// Last updated: 1/22/2026, 12:43:31 AM
1// class Solution {
2//     public int findMin(int[] nums) {
3//         int start=0;
4//         int end=nums.length-1;
5//         int min =Integer.MAX_VALUE;
6//         while(start<=end){
7//             int mid=start + (end-start)/2;
8//             //left sorted array
9//             if(nums[mid]>=nums[start]){
10//                 min = Math.min(min,nums[start]);
11//                 start=mid+1;
12//             }
13//             //right sorted array
14//             else if(nums[end]>=nums[mid]){
15//                 min = Math.min(min,nums[mid]);
16//                 end=mid-1;
17//             }
18//         }
19//         return min;
20//     }
21// }
22
23
24class Solution {
25    public int findMin(int[] nums) {
26        int start=0;
27        int end=nums.length-1;
28        int min =Integer.MAX_VALUE;
29        while(start<=end){
30            int mid=start + (end-start)/2;
31            //if the entire search space is sorted 
32            //then arr[low] will be smaller among them
33            if(nums[start]<=nums[end]){
34                min = Math.min(min,nums[start]);
35                return min;
36            }
37            //left sorted array
38            if(nums[mid]>=nums[start]){
39                min = Math.min(min,nums[start]);
40                start=mid+1;
41            }
42            //right sorted array
43            else if(nums[end]>=nums[mid]){
44                min = Math.min(min,nums[mid]);
45                end=mid-1;
46            }
47        }
48        return min;
49    }
50}
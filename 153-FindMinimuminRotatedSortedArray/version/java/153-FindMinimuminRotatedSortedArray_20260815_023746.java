// Last updated: 8/15/2026, 2:37:46 AM
1class Solution {
2    public int findMin(int[] nums) {
3
4        int low = 0;
5        int high = nums.length - 1;
6        int min = Integer.MAX_VALUE;
7
8        while (low <= high) {
9
10            int mid = low + (high - low) / 2;
11
12            // Current range is sorted
13            if (nums[low] < nums[high]) {
14                min = Math.min(min, nums[low]);
15                break;
16            }
17
18            // Cannot decide which side contains the minimum
19            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
20                min = Math.min(min, nums[low]);
21                low++;
22                high--;
23            }
24
25            else if (nums[low] <= nums[mid]) {
26                min = Math.min(min, nums[low]);
27                low = mid + 1;
28            }
29
30            else {
31                min = Math.min(min, nums[mid]);
32                high = mid - 1;
33            }
34        }
35
36        return min;
37    }
38}
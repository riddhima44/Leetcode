// Last updated: 3/1/2026, 1:56:54 PM
1class Solution {
2    public List<List<Integer>> fourSum(int[] nums, int target) {
3
4        List<List<Integer>> ans = new ArrayList<>();
5        int n = nums.length;
6
7        Arrays.sort(nums);
8
9        for(int i = 0; i < n - 3; i++) {
10
11            // skip duplicate i
12            if(i > 0 && nums[i] == nums[i-1])
13                continue;
14
15            for(int j = i + 1; j < n - 2; j++) {
16
17                // skip duplicate j
18                if(j > i + 1 && nums[j] == nums[j-1])
19                    continue;
20
21                int left = j + 1;
22                int right = n - 1;
23
24                while(left < right) {
25
26                    long sum =
27                        (long)nums[i] +
28                        nums[j] +
29                        nums[left] +
30                        nums[right];
31
32                    if(sum == target) {
33
34                        ans.add(Arrays.asList(
35                            nums[i],
36                            nums[j],
37                            nums[left],
38                            nums[right]
39                        ));
40
41                        left++;
42                        right--;
43
44                        // skip duplicates
45                        while(left < right &&
46                              nums[left] == nums[left-1])
47                            left++;
48
49                        while(left < right &&
50                              nums[right] == nums[right+1])
51                            right--;
52                    }
53
54                    else if(sum < target)
55                        left++;
56                    else
57                        right--;
58                }
59            }
60        }
61        return ans;
62    }
63}
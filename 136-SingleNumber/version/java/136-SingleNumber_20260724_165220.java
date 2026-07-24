// Last updated: 7/24/2026, 4:52:20 PM
1class Solution {
2    public int singleNumber(int[] nums) {
3        HashSet<Integer> set = new HashSet<>();
4        for(int x:nums){
5            if(set.contains(x)){
6                set.remove(x);
7            }
8            else{
9                set.add(x);
10            }
11        }
12        for(int num:set){
13            return num;
14        }
15        return -1;
16    }
17}
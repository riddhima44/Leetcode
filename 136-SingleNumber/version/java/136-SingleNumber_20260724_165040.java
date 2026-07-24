// Last updated: 7/24/2026, 4:50:40 PM
1class Solution {
2    public int singleNumber(int[] nums) {
3        HashMap<Integer,Integer> map = new HashMap<>();
4        for(int x: nums){
5            map.put(x,map.getOrDefault(x,0)+1);
6        }
7        for(int x:nums){
8            if(map.get(x)==1) return x;
9        }
10        return -1;
11    }
12}
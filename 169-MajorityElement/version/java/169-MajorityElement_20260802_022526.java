// Last updated: 8/2/2026, 2:25:26 AM
1class Solution {
2    public int majorityElement(int[] nums) {
3        HashMap<Integer,Integer> map = new HashMap<>();
4        for(int x:nums){
5            map.put(x,map.getOrDefault(x,0)+1);
6            if(map.get(x)>nums.length/2) return x;
7        }
8        return -1;
9    }
10}
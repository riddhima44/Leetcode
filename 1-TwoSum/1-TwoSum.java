// Last updated: 1/19/2026, 10:50:59 PM
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //this is the bettwe soln having tc as O(n) and sc as O(n)
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);

        }return new int[]{};
    }
}
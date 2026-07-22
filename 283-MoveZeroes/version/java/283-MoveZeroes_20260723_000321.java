// Last updated: 7/23/2026, 12:03:21 AM
1class Solution {
2    public void moveZeroes(int[] nums) {
3        //this is the bruteforce soln to this question having TC as O(2n) and SC as O(x)
4        //where x is number of non zero elements which as max can be n .
5        ArrayList<Integer> list= new ArrayList<>();
6        for(int i=0;i<nums.length;i++){
7            if(nums[i]!=0){
8                list.add(nums[i]);
9            }
10        }
11        for(int i=0;i<nums.length;i++){
12            if(i<list.size()){
13                nums[i] = list.get(i);
14            }
15            else{
16                nums[i] = 0;
17            }
18        }
19    }
20}
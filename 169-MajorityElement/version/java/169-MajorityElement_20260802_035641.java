// Last updated: 8/2/2026, 3:56:41 AM
1class Solution {
2    public int majorityElement(int[] nums) {
3        int elem=-1;
4        int count=0;
5        for(int i=0;i<nums.length;i++){
6            if(count==0) elem=nums[i];
7            if(nums[i]==elem){
8                count++;
9            }
10            else{
11                count--;
12            }
13        }
14        //This is just for verification for the case when majority elem is not present , not relevant for this prblm.
15        //tc O(2n) sc=O(n)
16        int newc=0;
17        for(int i=0;i<nums.length;i++){
18            if(nums[i]==elem) newc++;
19            if(newc>nums.length/2) return elem;
20        }
21        return -1;
22    }
23}
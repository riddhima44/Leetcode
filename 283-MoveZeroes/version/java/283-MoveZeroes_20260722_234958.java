// Last updated: 7/22/2026, 11:49:58 PM
1class Solution {
2    public void moveZeroes(int[] nums) {
3        int arr[] = new int[nums.length];
4        int i=0;
5        for(int j=0;j<nums.length;j++){
6            if(nums[j]!=0){
7                arr[i]=nums[j];
8                i++;
9            }
10        }
11        for(int j=i;j<arr.length;j++){
12            arr[j]=0;
13        }
14        for(int k=0;k<arr.length;k++){
15            nums[k]=arr[k];
16        }
17    }
18}
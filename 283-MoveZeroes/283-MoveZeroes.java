// Last updated: 1/19/2026, 10:49:10 PM
class Solution {
    public void moveZeroes(int[] nums) {
        //ye optimal soln hai aur iski TC hai O((x)+(n-x)) = O(n)
        //SC O(1) hai since we are not using any extra space
        //Space that we are using to solve this problem - O(n)
        int j=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) return;
        for(int i=j+1;i<nums.length;i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        

    }
}
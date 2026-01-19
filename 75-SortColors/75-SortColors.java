// Last updated: 1/19/2026, 10:49:51 PM
class Solution {
    public void sortColors(int[] nums) {
        //this is the optimal soln using dutch national flag algorithm having tc as O(n) and sc as O(1)
        int low=0;
        int high = nums.length-1;
        int mid=0;
        while(mid<=high){
            if(nums[mid]==0){
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                 nums[mid] = nums[high];
                 nums[high]=2;
                 high--;
            }
        }
    }
}
// Last updated: 1/19/2026, 10:50:20 PM
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1,-1};
        ans[0] = first(nums,target);
        if(ans[0]==-1) return new int[]{-1,-1};
        ans[1] = last(nums,target);
        return ans;
    }
    public int first(int[] nums,int target){
        int first=-1;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(nums[mid] == target){
                first=mid;
                end=mid-1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }return first;
    }

    public int last(int[] nums,int target){
        int last=-1;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(nums[mid] == target){
                last=mid;
                start=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }return last;
    }
}
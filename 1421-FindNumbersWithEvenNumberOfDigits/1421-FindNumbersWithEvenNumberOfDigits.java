// Last updated: 1/19/2026, 10:47:12 PM
class Solution {
    public int findNumbers(int[] nums) {
        int count=0;
        for(int ele:nums){
            String str = ele +"";
            if(str.length()%2==0){
                count++;
            }
        }
        return count;
    }
}
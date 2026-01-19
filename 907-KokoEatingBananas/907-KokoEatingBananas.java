// Last updated: 1/19/2026, 10:48:25 PM
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i:piles) max = Math.max(max,i);
        
        int left =1, right=max , ans=max; 
        while(left<=right){
            int mid=left +(right-left)/2;
            if(hours(piles,mid)<=h){
                right=mid-1;
                ans=mid;
            }else left=mid+1;
        }
        return ans;
    }
    public long hours(int[] piles,int mid){
        long total=0;
        for(int i:piles) total += (i+mid-1)/mid;
            return total;
    }
}
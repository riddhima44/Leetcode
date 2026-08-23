// Last updated: 8/23/2026, 12:20:35 PM
1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int max = -1;
4        for(int pile:piles){
5            max = Math.max(pile,max);
6        }
7        int low = 1;
8        int high = max;
9        int ans=0;
10        while(low<=high){
11            int mid = low+(high-low)/2;
12            long hours = fun(piles,mid);
13            if(hours<=h){
14                ans=mid;
15                high=mid-1;
16            }
17            else{
18                low=mid+1;
19            }
20        }
21        return ans;
22    }
23    long fun(int[] piles , int mid){
24        long th = 0;
25        for(int i=0;i<piles.length;i++){
26            th += (piles[i]+mid-1)/mid;
27        }
28        return th;
29    }
30}
// Last updated: 8/23/2026, 12:21:40 PM
1class Solution {
2    public int minEatingSpeed(int[] piles, int h) {
3        int max = -1;
4        for(int pile:piles){
5            max = Math.max(pile,max);
6        }
7        int low = 1;
8        int high = max;
9        while(low<=high){
10            int mid = low+(high-low)/2;
11            long hours = fun(piles,mid);
12            if(hours<=h){
13                high=mid-1;
14            }
15            else{
16                low=mid+1;
17            }
18        }
19        return low;
20    }
21    long fun(int[] piles , int mid){
22        long th = 0;
23        for(int i=0;i<piles.length;i++){
24            th += (piles[i]+mid-1)/mid;
25        }
26        return th;
27    }
28}
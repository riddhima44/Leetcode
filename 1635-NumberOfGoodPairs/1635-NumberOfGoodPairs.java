// Last updated: 1/19/2026, 10:46:45 PM
class Solution {
    public int numIdenticalPairs(int[] nums) {
        //optimal
        //tc O(n) and sc O(1)
        int pair=0;
        int freq[] = new int[101];
        for(int num :nums){
            pair+=freq[num];
            freq[num]++;
        }
        
        return pair;
    }
}
// Last updated: 1/19/2026, 10:48:59 PM
class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0,maxCount =0;
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int[] freq = new int[26];

       while(r<n){
            char ch= s.charAt(r);
            freq[ch-'A']++;
            maxCount=Math.max(maxCount,freq[ch-'A']);
            while(r-l+1-maxCount>k){
                char ch1=s.charAt(l);
                freq[ch1-'A']--;
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;
       }
       return maxLen==Integer.MIN_VALUE?0:maxLen;
    }
}
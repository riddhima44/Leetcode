// Last updated: 2/12/2026, 7:45:11 PM
1class Solution {
2    public int longestBalanced(String s) {
3        int n = s.length();
4        int maxLen = 0;
5        for (int i = 0; i < n; i++) {
6            int[] freq = new int[26];
7            for (int j = i; j <n;j++) {
8                freq[s.charAt(j)-'a']++;
9                int min=Integer.MAX_VALUE;
10                int max=0;
11                int distinct=0;
12                for (int k=0;k<26;k++){
13                    if(freq[k]>0){
14                        distinct++;
15                        min=Math.min(min,freq[k]);
16                        max=Math.max(max,freq[k]);
17                    }
18                }
19                if (min==max) {
20                    maxLen=Math.max(maxLen,j-i+1);
21                }
22            }
23        }
24        return maxLen;
25    }
26}
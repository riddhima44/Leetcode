// Last updated: 1/19/2026, 10:48:54 PM
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, ans = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { 
                ans++; 
                i++; 
                j++;
            } else {
                j++; 
            }
        }
        return ans;
    }
}
// Last updated: 1/19/2026, 10:46:44 PM

class Solution {
    public int numSub(String s) {
        long ans = 0;
        long count = 0;
        long mod = 1000000007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                ans = (ans + (count * (count + 1) / 2)) % mod;
                count = 0;
            }
        }

        // Add the last block if it ended with '1'
        ans = (ans + (count * (count + 1) / 2)) % mod;

        return (int) ans;
    }
}

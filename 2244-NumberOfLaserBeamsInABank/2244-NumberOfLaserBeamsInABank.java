// Last updated: 1/19/2026, 10:45:45 PM
class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int ans = 0;

        for (String row : bank) {
            int count = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') count++;
            }

            if (count > 0) {
                ans += prev * count;
                prev = count;
            }
        }
        return ans;
    }
}

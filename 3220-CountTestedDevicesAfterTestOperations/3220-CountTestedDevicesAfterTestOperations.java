// Last updated: 1/19/2026, 10:45:01 PM
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int tested = 0;
        int dec = 0;

        for (int i = 0; i < n; i++) {
            int cur = batteryPercentages[i] - dec;
            if (cur > 0) {
                tested++;
                dec++;
            }
        }

        return tested;
    }
}

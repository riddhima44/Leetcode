// Last updated: 1/19/2026, 10:46:10 PM
class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;

        int fullWeeksSum = 7 * (weeks * (weeks + 1) / 2) + 21 * weeks;
        int remainingDaysSum = days * (2 * (weeks + 1) + (days - 1)) / 2;

        return fullWeeksSum + remainingDaysSum;
    }
}

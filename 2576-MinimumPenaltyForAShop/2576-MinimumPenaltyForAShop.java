// Last updated: 1/19/2026, 10:45:14 PM
class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        // Initial penalty if shop closes at hour 0
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }

        int minPenalty = penalty;
        int bestHour = 0;

        // Move closing hour from 1 to n
        for (int hour = 1; hour <= customers.length(); hour++) {
            char prevHour = customers.charAt(hour - 1);

            if (prevHour == 'Y') {
                penalty--; // now open instead of closed
            } else {
                penalty++; // now open with no customers
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = hour;
            }
        }

        return bestHour;
    }
}

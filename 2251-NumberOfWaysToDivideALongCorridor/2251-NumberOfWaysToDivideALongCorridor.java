// Last updated: 1/19/2026, 10:45:43 PM
class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        
        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }
        
        // Basic impossible cases
        if (totalSeats == 0 || totalSeats % 2 != 0) return 0;
        
        long ways = 1;
        int seatCount = 0;
        int plantCount = 0;
        boolean countingPlants = false;
        
        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;
                
                // Finished one section (2 seats)
                if (seatCount % 2 == 0) {
                    countingPlants = true;
                    plantCount = 0;
                } 
                // Starting next section
                else if (seatCount > 1) {
                    ways = (ways * (plantCount + 1)) % MOD;
                    countingPlants = false;
                }
            } 
            else if (c == 'P' && countingPlants) {
                plantCount++;
            }
        }
        
        return (int) ways;
    }
}

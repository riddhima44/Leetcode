// Last updated: 1/19/2026, 10:46:51 PM
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];

        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; // placeholder
            } else {
                int lake = rains[i];
                ans[i] = -1;

                if (lastRain.containsKey(lake)) {
                    int prevDay = lastRain.get(lake);
                    Integer dryDay = dryDays.higher(prevDay);

                    if (dryDay == null) {
                        return new int[0]; // flood unavoidable
                    }

                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }

                lastRain.put(lake, i);
            }
        }
        return ans;
    }
}

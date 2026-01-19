// Last updated: 1/19/2026, 9:57:03 PM
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        // prefixSkill[i] = sum of skill[0..i-1]
        long[] prefixSkill = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSkill[i + 1] = prefixSkill[i] + skill[i];
        }

        long start = 0; // start time of previous potion

        for (int j = 1; j < m; j++) {
            long delay = 0;

            for (int i = 0; i < n; i++) {
                long prevFinish =
                        prefixSkill[i + 1] * mana[j - 1];
                long currStart =
                        prefixSkill[i] * mana[j];

                delay = Math.max(delay, prevFinish - currStart);
            }

            start += delay;
        }

        // Add full pipeline time of last potion
        long totalSkill = prefixSkill[n];
        return start + totalSkill * mana[m - 1];
    }
}

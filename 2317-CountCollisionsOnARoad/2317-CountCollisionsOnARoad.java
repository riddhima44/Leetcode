// Last updated: 1/19/2026, 10:45:37 PM
class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();
        int i = 0, j = n - 1;

        while (i < n && directions.charAt(i) == 'L') i++;
        while (j >= 0 && directions.charAt(j) == 'R') j--;

        int collisions = 0;
        for (int k = i; k <= j; k++) {
            char c = directions.charAt(k);
            if (c != 'S') collisions++;
        }

        return collisions;
    }
}

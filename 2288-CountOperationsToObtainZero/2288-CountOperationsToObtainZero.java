// Last updated: 1/19/2026, 10:45:38 PM
class Solution {
    public int countOperations(int num1, int num2) {
        int ops = 0;

        while (num1 != 0 && num2 != 0) {
            if (num1 < num2) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            ops += num1 / num2;
            num1 = num1 % num2;
        }

        return ops;
    }
}

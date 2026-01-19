// Last updated: 1/19/2026, 10:50:37 PM
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            max = Math.max(max, h * width);

            // move the smaller height pointer, because keeping it is useless
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}

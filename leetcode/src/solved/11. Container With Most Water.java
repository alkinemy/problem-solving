/**
 * https://leetcode.com/problems/container-with-most-water/
 */

class Solution {
    public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
			return 0;
		}
		int left = 0;
		int right = height.length - 1;

		int max = 0;
		while (left < right) {
			int leftHeight = height[left];
			int rightHeight = height[right];
			int current = Math.min(leftHeight, rightHeight) * (right - left);
			max = Math.max(max, current);
			if (leftHeight < rightHeight) {
				left++;
			} else if (leftHeight > rightHeight){
				right--;
			} else {
				leftNext = height[left + 1];
				rightNext = height[right - 1];
				if (leftNext > rightNext) {
					left++;
				} else {
					right--;
				}
			}
		}
		return max;
    }
}

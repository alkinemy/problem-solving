/**
 * https://leetcode.com/problems/find-pivot-index/
 */

class Solution {
    public int pivotIndex(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		int left = 0;
		int right = sum;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				left += nums[i - 1];
			}
			right -= nums[i];
			if (left == right) {
				return i;
			}
		}
		return -1;
    }
}

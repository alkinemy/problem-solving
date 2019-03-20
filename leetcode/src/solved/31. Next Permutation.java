/**
 * https://leetcode.com/problems/next-permutation/
 */

class Solution {
    public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int from = -1;
		int to = nums.length - 1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i]) {
				from = i;
				break;
			}
		}
		if (from == -1) {
			Arrays.sort(nums);
			return nums;
		}

		for (int i = nums.length - 1; i > from; i--) {
			if (nums[from] < nums[i]) {
				to = i;
				break;
			}
		}

		swap(nums, from, to);
		return Arrays.sort(nums, from + 1, nums.length);
    }

	void swap(int[] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}
}

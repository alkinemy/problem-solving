/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */

//first answer
class Solution {
    public int subarraySum(int[] nums, int k) {
		int[] sums = new int[nums.length];

		int count = 0;
		for (int r = 0; r < nums.length; r++) {
			for (int c = r; c < nums.length; c++) {
				if (c == r) {
					sums[c] = nums[c];
				} else {
					sums[c] = nums[c] + sums[c - 1];
				}
				if (sums[c] == k) {
					count++;
				}
			}
		}
		return count;
    }
}

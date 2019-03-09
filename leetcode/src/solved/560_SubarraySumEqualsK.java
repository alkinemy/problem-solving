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

//second answer(cheated)
class Solution {
    public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> sums = new HashMap<>();
		
		int count = 0;
		int current = 0;
		for (int i = 0; i < nums.length; i++) {
			current += nums[i];
			if (current == k) {
				count++;
			}
			count += sums.getOrDefault(current - k, 0);
			if (sums.containsKey(current)) {
				sums.put(current, sums.get(current) + 1);
			} else {
				sums.put(current, 1);
			}
		}
		return count;
	}
}

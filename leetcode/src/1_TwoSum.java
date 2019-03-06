/**
 * https://leetcode.com/problems/two-sum/
 */

class Solution {
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		return null;
	}
}

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			Integer diffIndex = map.get(diff);
			if (diffIndex != null && diffIndex != i) {
				return new int[] {i, diffIndex};
			}
		}
		return null;
	}
}

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = target - nums[i];
			if (map.containsKey(diff)) {
				int diffIndex = map.get(diff);
				if (diffIndex != i) {
					return new int[] {diffIndex, i};
				}
			}
			map.put(nums[i], i);
		}
		return null;
	}
}

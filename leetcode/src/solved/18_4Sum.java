/**
 * https://leetcode.com/problems/4sum/
 */


class Solution {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for(int start = 0; start < nums.length - 1; start++) {
			if (start != 0 && nums[start] == nums[start - 1]) {
				continue;
			}
			for(int end = nums.length - 1; end > start; end--) {
				if (end != nums.length - 1 && nums[end] == nums[end + 1]) {
					continue;
				}
				int forward = start + 1;
				int backward = end - 1;
				while(forward < backward) {
					int sum = nums[start] + nums[end] + nums[forward] + nums[backward];
					if (sum == target) {
						List<Integer> q = new ArrayList<>();
						q.add(nums[start]);
						q.add(nums[forward]);
						q.add(nums[backward]);
						q.add(nums[end]);
						result.add(q);
						forward++;
						backward--;

						while(forward < backward && nums[forward - 1] == nums[forward]) {
							forward++;
						}
						while(forward < backward && nums[backward] == nums[backward + 1]) {
							backward--;
						}
					} else if (sum < target) {
						forward++;
					} else {
						backward--;
					}
				}
			}
		}
		return result;
	}

}

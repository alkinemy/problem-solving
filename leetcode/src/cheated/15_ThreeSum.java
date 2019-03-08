/**
 * https://leetcode.com/problems/3sum/
 */

class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				int start = i + 1;
				int end = nums.length - 1;
				while (start < end) {
					int sum = nums[i] + nums[start] + nums[end];
					if (sum == 0) {
						List<Integer> result = new ArrayList<>();
						result.add(nums[i]);
						result.add(nums[start]);
						result.add(nums[end]);
						results.add(result);
						start++;
						end--;
						while(start < end && nums[start - 1] == nums[start]) {
							start++;
						}
						while(start < end && nums[end + 1] == nums[end]) {
							end--;
						}
					} else if (sum < 0) {
						start++; //정렬된 상태니까 합을 키우려면 start를 증가시켜야 함
					} else {
						end--; //정렬된 상태니까 합을 줄이려면 end를 감소시켜야 함
					}
				}
			}
		}
		return results;
	}
}

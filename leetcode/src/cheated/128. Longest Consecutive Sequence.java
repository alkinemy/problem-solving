/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */

class Solution {
    public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		Set<Integer> numsSet = new HashSet<>();
		for (int num : nums) {
			numsSet.add(num);
		}

		int longest = 1;
		for (int num : nums) {
			if (numsSet.contains(num - 1)) {
				continue;
			}
			int length = 1;
			int current = num + 1;
			while(numsSet.contains(current)) {
				current++;
				length++;
			}
			longest = Math.max(longest, length);
		}
		return longest;
    }
}

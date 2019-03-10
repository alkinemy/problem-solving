/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

class Solution {
    public int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}
		int start = 0;
		int end = nums.length;
 		while (start < end) {
			int middleIndex = (start + end) / 2;
			int middle = nums[middleIndex];
			if (middle == target) {
				return middleIndex;
			}
			int first = nums[start];
			if (first == target) {
				return start;
			}
			int last = nums[end - 1];
			if (last == target) {
				return end - 1;
			}
			if (first < middle) {
				if (first < target && target < middle) {
					start = start;
					end = middleIndex;
					continue;
				} else if (middle < target || target < first) {
					start = middleIndex + 1;
					end = end;
					continue;
				} 
			} else {
				if (first < target && target < middle) {
					start = start;
					end = middleIndex;
					continue;
				} else if (middle < target && target < first) {
					start = middleIndex + 1;
					end = end;
					continue;
				}
			}
		}
		return -1;
    }
}

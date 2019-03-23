/**
 * https://leetcode.com/problems/merge-sorted-array/
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m + n - 1;
		int mi = m - 1;
		int ni = n - 1;
		while (i >= 0) {
			if (mi < 0) {
				nums1[i] = nums2[ni];
				ni--;
				i--;
			} else if (ni < 0) {
				return;
			} else if (nums1[mi] >= nums2[ni]) {
				nums1[i] = nums1[mi];
				i--;
				mi--;
			} else if (nums1[mi] < nums2[ni]) {
				nums1[i] = nums2[ni];
				i--;
				ni--;
			}
		}
    }
}

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] n;
		int[] m;
		if (nums1.length > nums2.length) {
			n = nums2;
			m = nums1;
		} else {
			n = nums1;
			m = nums2;
		}

		int nCut = n.length / 2;
		int mCut = (n.length + m.length + 1) / 2 - nCut;

		while (nCut <= n.length && nCut >= 0) {
			int nCutAfter = nCut == n.length ? Integer.MAX_VALUE : n[nCut];
			int nCutBefore = nCut == 0 ? Integer.MIN_VALUE : n[nCut - 1];
			int mCutAfter = mCut == m.length ? Integer.MAX_VALUE : m[mCut];
			int mCutBefore = mCut == 0 ? Integer.MIN_VALUE : m[mCut - 1];

			if (nCutAfter < mCutBefore) { //n의 left part가 너무 작음, nCut을 뒤로 보내야 함
				nCut++;
				mCut--;
				continue;
			}
			if (nCutBefore > mCutAfter) { //n의 left part가 너무 큼, nCut을 앞으로 보내야 함
				nCut--;
				mCut++;
				continue;
			}
			
			if ((n.length + m.length) % 2 == 0) {
				return ((double)(Math.max(nCutBefore, mCutBefore) + Math.min(nCutAfter, mCutAfter))) / 2;
			} else {
				return (double)(Math.max(nCutBefore, mCutBefore));
			}
		}

		return 0d;
    }

}

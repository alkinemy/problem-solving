/*
 * https://leetcode.com/problems/4sum-ii/
 */

class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> abSums = new HashMap<>();
		for (int a = 0; a < A.length; a++) {
			for (int b = 0; b < B.length; b++) {
				int abSum = A[a] + B[b];
				if (abSums.containsKey(abSum)) {
					abSums.put(abSum, abSums.get(abSum) + 1);
				} else {
					abSums.put(abSum, 1);
				}
			}
		}

		int count = 0;
		for (int c = 0; c < C.length; c++) {
			for (int d = 0; d < D.length; d++) {
				int cdSum = C[c] + D[d];
				if (abSums.containsKey(-cdSum)) {
					count += abSums.get(-cdSum);
				}
			}
		}
		return count;
    }
}

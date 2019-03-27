/**
 * https://leetcode.com/problems/flipping-an-image/
 */

//answer, time: O(MN), space: O(MN)
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
		if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
			return null;
		}

		int[][] result = new int[A.length][A[0].length];
		for (int r = 0; r < A.length; r++) {
			int columnLength = A[r].length;
			for (int c = 0; c < columnLength; c++) {
				result[r][c] = A[r][columnLength - c - 1] ^ 1;
			}
		}
		return result;
    }
}

//solution, time: O(MN), space: O(1)
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return null;
        }

        for (int r = 0; r < A.length; r++) {
            int columnLength = A[r].length;
            for (int c = 0; c < (columnLength + 1) / 2; c++) {
                int temp = A[r][c] ^ 1;
                A[r][c] = A[r][columnLength - c - 1] ^ 1;
                A[r][columnLength - c - 1] = temp;
            }
        }
        return A;
    }
}

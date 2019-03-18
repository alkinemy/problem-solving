/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */

//same logic as no.54
class Solution {
    public int[][] generateMatrix(int n) {
		if (n == 0) {
			return new int[0][0];
		}

		int[][] result = new int[n][n];
		int r1 = 0;
		int c1 = 0;
		int r2 = n - 1;
		int c2 = n - 1;
		int current = 1;
		while(r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++) {
				result[r1][c] = current++;
			}
			for (int r = r1 + 1; r <= r2; r++) {
				result[r][c2] = current++;
			}
			if (r1 < r2 && c1 < c2) {
				for (int c = c2 - 1; c > c1; c--) {
					result[r2][c] = current++;
				}
				for (int r = r2; r > r1; r--) {
					result[r][c1] = current++;
				}
			}

			r1++;
			c1++;
			r2--;
			c2--;
		}
		return result;
    }
}

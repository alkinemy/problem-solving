
/*
 * https://practice.geeksforgeeks.org/problems/rotate-a-2d-array-without-using-extra-space/0
 */

void rotate(int[][] array) {
	int n = array.length;
	for (int r = 0; r < n / 2; r++) {
		for (int c = r; c < n - r - 1; c++) {
			int temp = array[r][c];
			array[r][c] = array[n - c - 1][r];
			array[n - c - 1][r] = array[n - r - 1][n - c - 1];
			array[n - r - 1][n - c - 1] = array[c][n - r - 1];
			array[c][n - r - 1] = temp;
		}
	}
}


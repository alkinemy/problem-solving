//행렬 회전


//O(n^2)
int[][] rotate(int[][] matrix) {
	int n = matrix.length;
	int[][] result = new int[n][n];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			result[j][n - i - 1] = matrix[i][j];
		}
	}
	return result;
}

//
// (n - 0 - 1) + (n - 1 - 1) + (n - 2 - 1) + ... + (n - n/2 + 1 - 1)
// (n - 1) + (n - 2) + (n - 3) + ... + (n - n/2) = n * n/2 - (1 + ... + n/2)
// O(n^2)
int[][] rotate2(int[][] matrix) {
	int n = matrix.length;

	for (int i = 0; i < n / 2; i++) {
		for (int j = i; j < n - i - 1; j++) {
			int temp = matrix[i][j];
			matrix[i][j] = matrix[n-j-1][i];
			matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
			matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
			matrix[j][n-i-1] = temp;
		}
	}
	return matrix;
}

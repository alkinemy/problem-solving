//0행렬



// 방법1. 0으로 만들 행/열을 마킹해둔 후에 나중에 처리
// 방법2. 새로 행렬을 만든다
// O(n^2)
int[][] zeroMatrix(int[][] matrix) {
	int n = matrix.length;
	boolean[] isZeroColumn = new boolean[n];
	
	boolean isZeroRow = false;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (matrix[i][j] == 0) {
				isZeroRow = true;
				isZeroColumn[j] = true;
				matrix[i][j] = 0;
				continue;
			}

			if (isZeroColumn[j]) {
				matrix[i][j] = 0;
				continue;
			}

			if (isZeroRow) {
				matrix[i][j] = 0;
				continue;
			}
		}
		isZeroRow = false;
	}
	return matrix;
}

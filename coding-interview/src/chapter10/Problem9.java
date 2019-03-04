
class Position {
	int row;
	int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
}

Position findIndex(int[][] matrix, int x) {
	int rowStart = matrix.length - 1;
	int rowEnd = 0;
	for (int i = 0; i < matrix.length; i++) {
		int[] row = matrix[i];
		if (row[0] <= x && x <= row[row.length - 1]) {
			if (rowStart > i) {
				rowStart = i;
			}
			if (rowEnd < i) {
				rowEnd = i;
			}
		}
	}
	if (rowStart > rowEnd) {
		return new Position(-1, -1);
	}

	int columnStart = matrix[0].length - 1;
	int columnEnd = 0;
	int[] startRow = matrix[0];
	int[] endRow = matrix[matrix.length - 1];
	for (int i = 0; i < matrix[0].length; i++) {
		if (startRow[i] <= x && x <= endRow[i]) {
			if (columnStart > i) {
				columnStart = i;
			}
			if (columnEnd < i) {
				columnEnd = i;
			}
		}
	}
	if (columnStart > columnEnd) {
		return new Position(-1, -1);
}
	for (int i = rowStart; i <= rowEnd; i++) {
		int index = binarySearch(matrix[i], x, columnStart, columnEnd);
		if (index != -1) {
			return new Position(i, index);
		}
	}
	return new Position(-1, -1);
}

int binarySearch(int[] array, int x, int start, int end) {
	if (start > end) {
		return -1;
	}
	
	int middle = (start + end) / 2;
	int middleValue = array[middle];
	
	if (middleValue == x) {
		return middle;
	}
	if (middleValue > x) {
		return binarySearch(array, x, start, middle - 1);
	}
	return binarySearch(array, x, middle + 1, end);
}

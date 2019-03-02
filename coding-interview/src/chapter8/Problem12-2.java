void findPaths(int[] rows, int column, List<int[]> result) {
	if (column == rows.length) {
		result.add(Arrays.copyOf(rows, rows.length));
		return;
	}

	for (int i = 0; i < rows.length; i++) {
		if (isAvailableColumn(rows, column, i)) {
			rows[column] = i;
			findPaths(rows, column + 1, result);
		}
	}
}

boolean isAvailableColumn(int[] rows, int column, int row) {
	for (int i = 0; i < column; i++) {
		int ithRow = rows[i];
		if (rows[i] == row) {
			return false;
		}

		if (Math.abs(ithRow - row) == Math.abs(i - column)) {
			return false;
		}

	}
	return true;
}


/*
 * https://practice.geeksforgeeks.org/problems/replace-os-with-xs/0
 */

void replace(char[][] array) {
	for (int r = 0; r < array.length; r++) {
		for (int c = 0; c < array[0].length; c++) {
			if (checked[r][c]) {
				continue;
			}
			boolean[][] checked = new boolean[array.length][array[0].length];
			if (array[r][c] == 'O' && isSurrounded(array, r, c, checked)) {
				replaceToX(array, r, c);
			}
		}
	}
}

boolean isSurrounded(char[][] array, int r, int c, boolean[][] checked) {
	//left, right, up, down
	int[] rows =    {    r,     r, r - 1, r + 1};
	int[] columns = {c - 1, c + 1,     c,     c};

	checked[r][c] = true;
	boolean surrounded = true;
	for (int i = 0; i < 4; i++) {
		int row = rows[i];
		int column = columns[i];
		if (row < 0 || row >= array.length || column < 0 || column >= array[0].length) {
			return false;
		}
		else if (array[row][column] == 'O' && !checked[row][column]) {
			surrounded &= isSurrounded(array, row, column, checked);
		}
	}
	return surrounded;
}

void  replaceToX(char[][] array, int r, int c) {
	//left, right, up, down
	int[] rows =    {    r,     r, r - 1, r + 1};
	int[] columns = {c - 1, c + 1,     c,     c};

	array[row][column] = 'X';
	for (int i = 0; i < 4; i++) {
		int row = rows[i];
		int column = columns[i];
		if (row < 0 || row >= array.length || column < 0 || column >= array[0].length) {
			continue;
		}
		if (array[row][column] == 'O') {
			replaceToX(array, row, column);
		}
	}
}

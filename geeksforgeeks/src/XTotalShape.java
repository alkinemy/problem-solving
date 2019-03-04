/*
 * https://practice.geeksforgeeks.org/problems/x-total-shapes/0
 */

int count(char[][] array) {
	int count = 0;
	boolean[][] visited = new boolean[array.length][array[0].length];
	for (int r = 0; r < array.length; r++) {
		char[] row = array[r];
		for (int c = 0; c < row.length; c++) {
			if (visited[r][c]) {
				continue;
			}
			visited[r][c] = true;
			if (array[r][c] == 'X') {
				count++;
				visitAllX(array, r, c, visited);
			}
		}
	}
	return count;
}

void visitAllX(char[][] array, int r, int c, boolean[][] visited) {
	//left, right, up, down
	int[] rows = {r, r, r - 1, r + 1};
	int[] columns = {c - 1, c + 1, c, c};
	for (int i = 0; i < 4; i++) {
		int row = rows[i];
		int column = columns[i];
		if ((row >= 0 && row < array.length) && (column >= 0 && column < array[0].length) && !visited[row][column] && array[row][column] == 'X') {
			visited[r][c] = true;
			visitAllX(array, row, column, visited);				
		}
	}
}

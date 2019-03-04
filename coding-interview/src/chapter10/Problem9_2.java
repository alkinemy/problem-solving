class Position {
	int row;
	int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
}

Posotion findPosition(int[][] matrix, int x) {
	int r = 0;
	int c = matrix[0].length - 1;
	while (!(r >= matrix.length || c < 0)) {
		if (matrix[r][c] == x) {
			return new Position(r, c);
		}
		if (matrix[r][c] > x) {
			c--;
		} else {
			r++;
		}
	}
	return new Position(-1, -1);
}


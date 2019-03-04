

class Coordinate {
	int row;
	int column;

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}

	boolean isInbound(int[][] matrix) {
		return 0 <= row && row < matrix.length
			&& 0 <= column && column < matrix[0].length;
	}

	boolean isBefore(Coordinate c) {
		return row <= c.row && column <= c.column;
	}
}


Coordinate findCoordinateOf(int[][] matrix, Coordinate start, Coordinate end, int x) {
	if (!(start.isInbound(matrix) && end.isInbound(matrix))) {
		return null;
	}

	if (!start.isBefore(end)) {
		return null;
	}

	if (matrix[start.row][start.column] == x) {
		return start;
	}

	if (matrix[end.row][end.column] == x) {
		return end;
	}

	int diagonal = Math.min(end.row - start.row, end.column - start.column);
	Coordinate de = new Coordinate(start.row + diagonal, start.column + diagonal);
	Coordinate ds = new Coordinate(start.row, start.column);
	while (ds.isBefore(de)) {
		Coordinate p = new Coordinate((ds.row + de.row) / 2, (ds.column + de.column) / 2);
		if (x > matrix[p.row][p.column]) {
			ds.row++;
			ds.column++;
		} else if (x < matrix[p.row][p.column]) {
			de.row--;
			de.column--;
		} else {
			return p;
		}
	}

	return partition(matrix, start, end, ds, x);
}

Coordinate partition(int[][] matrix, Coordinate start, Coordinate end, Coordinate pivot, int x) {
	Coordinate leftLowerStart = new Coordinate(pivot.row, start.column);
	Coordinate leftLowerEnd = new Coordinate(end.row, pivot.column - 1);
	Coordinate rightUpperStart = new Coordinate(start.row, pivot.column);
	Coordinate rightUpperEnd = new Coordinate(pivot.row -1 , end.column);

	Coordinate leftLower = findCoordinateOf(matrix, leftLowerStart, leftLowerEnd, x);
	if (leftLower != null) {
		return leftLower;
	}
	return findCoordinateOf(matrix, rightUpperStart, rightUpperEnd, x);
}


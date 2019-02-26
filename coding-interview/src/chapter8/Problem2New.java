

class Point {
	int row;
	int column;

	public Point(int row, int column) {
		this.row = row;
		this.column = column;
	}

	//override equals and hash code
}

List<Point> getPath(boolean[][] maze) {
	if (maze == null || maze.length == 0) {
		return null;
	}
	List<Point> path = new ArrayList<>();
	Set<Point> failPoints = new HashSet<>();
	if (getPath(maze, maze.length - 1, maze[0].length - 1, path), failPoints) {
		return path;
	}
	return null;
}

boolean getPath(boolean[][] maze, int row, int column, List<Point> path) {
	if (column < 0 || row < 0 || !maze[row][column]) {
		return false;
	}

	Point p = new Point(row, column);
	if (failPoints.contains(p)) {
		return false;
	}

	boolean isAtOrigin = (row == 0) && (column == 0);
	if (isAtOrigin || getPath(maze, row, column - 1, path, failPoints) || getPath(maze, row - 1, column, path, failPoints)) {
		path.add(p);
		return true;
	}
	failPoints.add(p);
	return false;
}

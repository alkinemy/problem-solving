List<String> getPath(int[][] grid, int r, int c) {
	if (r == 1 && c == 1) {
		return new ArrayList<>();
	}
	if (r == 1) {
		List<String> path = new ArrayList<>();
		path.add("E");
		path.addAll(getPath(grid, r, (c - 1)));
		return path;
	}
	if (c == 1) {
		List<String> path = new ArrayList<>();
		path.add("S");
		path.addAll(getPath(grid, (r - 1), c));
		return path;
	}

	if (grid[r - 1][c]) {
		List<String> path = new ArrayList<>();
		path.add("S");
		path.addAll(getPath(grid, (r - 1), c));
		return path;
	}
	if (grid[r][c - 1]) {
		List<String> path = new ArrayList<>();
		path.add("E");
		path.addAll(getPath(grid, r, (c - 1)));
		return path;
	}

	throw new IllegalStateException("Cannot find a path");
}

String[] getPath(int[][] grid, int r, int c) {
	if (r == 1 && c == 1) {
		List<String> path = new ArrayList<>();
		path.add("");
		return path;
	}
	String[][][] paths = new String[r - 1][c - 1][];
	paths[r - 1][c - 1] = new String[] { "" };
	paths[r - 2][c - 1] = new String[] { "S" };
	paths[r - 1][c - 2] = new String[] { "E" };

	for (int column = c - 3; column >= 0; column--) {
		paths[r - 1][column] = "E" + paths[r - 1][column + 1][0];
	}
	for (int row = r - 3; row >= 0; row--) {
		paths[row][c - 1] = "S" + paths[row + 1][c - 1][0];
	}

	for(int column = c - 4; column >= 0; column--) {
		for (int row = r - 4; row >= 0; row--) {
			paths[row][column] = new String[path[row + 1][column].length + path[row][column + 1].length];
			int k = 0;
			for (int i = 0; i < path[row + 1][column].length; i++) {
				paths[row][column][k] = "S" + paths[row + 1][column][i];
				k++;
			}
			for (int i = 0; i < path[row][column + 1].length; i++) {
				paths[row][column][k] = "E" + paths[row][column + 1][i];
				k++;
			}
		}
	}
	return paths[0][0];

}

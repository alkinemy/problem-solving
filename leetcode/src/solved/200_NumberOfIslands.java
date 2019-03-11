/**
 * https://leetcode.com/problems/number-of-islands/
 */

class Solution {

    public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for(int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (visited[r][c]) {
					continue;
				}
				if (grid[r][c] == '1') {
					count++;
					visitIsland(grid, r, c, visited);
				} else {
					visited[r][c] = true;
				}
			}
		}
		return count;
    }

	void visitIsland(char[][] grid, int r, int c, boolean[][] visited) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
			return;
		}
		if (visited[r][c]) {
			return;
		}
		if (grid[r][c] == '0') {
			return;
		}

		visited[r][c] = true;
		//left, right, up, down
		int[] rows =    {    r,     r, r - 1, r + 1};
		int[] columns = {c - 1, c + 1,     c,     c};
		
		for (int i = 0; i < 4; i++) {
			visitIsland(grid, rows[i], columns[i], visited);
		}
	}

}

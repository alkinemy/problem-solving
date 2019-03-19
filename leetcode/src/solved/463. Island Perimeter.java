/**
 * https://leetcode.com/problems/island-perimeter/
 */

//first answer(dfs)
class Solution {
    public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		for (int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 1) {
					boolean[][] visited = new boolean[grid.length][grid[0].length];
					return calculatePerimeter(grid, visited, r, c);
				}
			}
		}
		return 0;
    }

	int calculatePerimeter(int[][] grid, boolean[][] visited, int r, int c) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
			return 1;
		}
		if (visited[r][c]) {
			return 0;
		}
		if (grid[r][c] == 0) {
			return 1;
		}

		visited[r][c] = true;
		//left, right, up, down
		int[] rows =    { 0, 0, -1, 1};
		int[] columns = {-1, 1,  0, 0};
		
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += calculatePerimeter(grid, visited, r + rows[i], c + columns[i]);
		}
		return result;
	}

}



//one of answer(solution) - no additional memory
class Solution {
    public int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int cells = 0;
		int adjacent = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				if (grid[r][c] == 1) {
					cells++;
					if (r + 1 < grid.length && grid[r + 1][c] == 1) {
						adjacent++;
					}
					if (c + 1 < grid[0].length && grid[r][c + 1] == 1) {
						adjacent++;
					}
				} 
			}
		}
		return cells * 4 - adjacent * 2;
	}
}








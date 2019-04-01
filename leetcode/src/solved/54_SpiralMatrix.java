/**
 * https://leetcode.com/problems/spiral-matrix/
 */

//first answer
class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return Collections.emptyList();
		}

		int shortLength = Math.min(matrix.length, matrix[0].length);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < shortLength / 2; i++) {
			//left -> right
			for(int c = i; c < matrix[i].length - i; c++) {
				result.add(matrix[i][c]);
			}
			//up -> down
			for(int r = i + 1; r < matrix.length - i; r++) {
				result.add(matrix[r][matrix[i].length - 1 - i]);
			}   
			//right -> left
			for (int c = matrix[i].length - 2 - i; c >= i; c--) {
				result.add(matrix[matrix.length - 1 - i][c]);
			}   
			//down -> up
			for (int r = matrix.length - 2 - i; r > i; r--) {
				result.add(matrix[r][i]);
			}   
		}   

		if (shortLength % 2 == 1) {
			int i = shortLength / 2;
			if (matrix.length == shortLength) { //row
				for (int c = i; c < matrix[i].length - i; c++){
					result.add(matrix[i][c]);
				}
			} else { //column
				for (int r = i; r < matrix.length - i; r++) {
					result.add(matrix[r][i]);
				}
			}   
		} 

		return result;
	}   
}





//simulation(solution)
class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return Collections.emptyList();
		}
		int rows = matrix.length;
		int columns = matrix[0].length;

		boolean[][] seen = new boolean[rows][columns];
		List<Integer> result = new ArrayList<>();
		//right down left up
		int[] rowDirection =    {0, 1,  0, -1};
		int[] columnDirection = {1, 0, -1,  0};
		int r = 0;
		int c = 0;
		int direction = 0;
		for(int i = 0; i < rows * columns; i++) {
			result.add(matrix[r][c]);
			seen[r][c] = true;
			int nextR = r + rowDirection[direction];
			int nextC = c + columnDirection[direction];
			if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < columns && !seen[nextR][nextC]) {
				r = nextR;
				c = nextC;
			} else {
				direction = (direction + 1) % 4;
				r += rowDirection[direction];
				c += columnDirection[direction];
			}
		}
		return result;
	}
}



//layer by layer(solution)
class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return Collections.emptyList();
		}

		int r1 = 0;
		int c1 = 0;
		int r2 = matrix.length - 1;
		int c2 = matrix[0].length - 1;
		List<Integer> result = new ArrayList<>();
		while(r1 <= r2 && c1 <= c2) {
			for (int c = c1; c <= c2; c++) {
				result.add(matrix[r1][c]);
			}
			for (int r = r1 + 1; r <= r2; r++) {
				result.add(matrix[r][c2]);
			}
			if (r1 < r2 && c1 < c2) {
				for (int c = c2 - 1; c >= c1; c--) {
					result.add(matrix[r2][c]);
				}
				for (int r = r2 - 1; r > r1; r--) {
					result.add(matrix[r][c1]);
				}
			}
			r1++;
			c1++;
			r2--;
			c2--;
		}
		return result;
	}
}

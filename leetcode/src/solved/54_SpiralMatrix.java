/**
 * https://leetcode.com/problems/spiral-matrix/
 */


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return Collections.emptyList();
		}
		
		int shortLength = Math.min(matrix.length, matrix[0].length);
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i <= shortLength / 2; i++) {
			//left -> right
			
			for(int c = i; c < matrix[i].length - i; c++) {
				result.add(matrix[i][c]);
			}
			//up -> down
			for(int r = i + 1; r < matrix.length - i; r++) {
				result.add(matrix[r][matrix[i].length - 1 - i]);
			}
			//right -> left
			if (matrix.length - 1 - i != i) {
				for (int c = matrix[i].length - 2 - i; c >= i; c--) {
					result.add(matrix[matrix.length - 1 - i][c]);
				}
			}
			//down -> up
			if (matrix[i].length - 1 - i != i) {
				for (int r = matrix.length - 2 - i; r > i; r--) {
					result.add(matrix[r][i]);
				}
			}
		}
		return result;
    }
}

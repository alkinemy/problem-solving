/**
 * https://leetcode.com/problems/game-of-life/
 */

//first answer, space: O(NM)
class Solution {
    public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int[][] result = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int current = board[i][j];
				int count = countLiveCells(board, i, j);
				if ((current == 1 && (count == 2 || count == 3)) || (current == 0 && count == 3)) {
					result[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = result[i][j];
			}
		}
    }

	int countLiveCells(int[][] board, int r, int c) {
		//좌상/상/우상/우/우하/하/좌하/좌
		int[] rows =    {-1, -1, -1, 0, 1, 1,  1,  0};
		int[] columns = {-1,  0,  1, 1, 1, 0, -1, -1};

		int count = 0;
		for (int i = 0; i < 8; i++) {
			int row = r + rows[i];
			int column = c + columns[i];
			if (row >= 0 && row < board.length && column >= 0 && column < board[0].length) {
				count += board[row][column];
			}
		}
		return count;
	}
}



//second answer(in-place?) space: O(N)
class Solution {
    public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		int[] currentLineCorrection = new int[board[0].length];
		int[] nextLineCorrection = null;
		for (int i = 0; i < board.length; i++) {
			nextLineCorrection = new int[board[0].length];
			for (int j = 0; j < board[i].length; j++) {
				int current = board[i][j];
				int count = countLiveCells(board, i, j, currentLineCorrection);
				if (current == 1) {
					if (count != 2 && count != 3) {
						board[i][j] = 0;
						if (j + 1 < board[i].length) {
							currentLineCorrection[j + 1]++;
							nextLineCorrection[j + 1]++;
						}
						nextLineCorrection[j]++;
						if (j - 1 >= 0) {
							nextLineCorrection[j - 1]++;
						}
					}
				} else {
					if (count == 3) {
						board[i][j] = 1;
						if (j + 1 < board[i].length) {
							currentLineCorrection[j + 1]--;
							nextLineCorrection[j + 1]--;
						}
						nextLineCorrection[j]--;
						if (j - 1 >= 0) {
							nextLineCorrection[j - 1]--;
						}
					}
				}
			}
			currentLineCorrection = nextLineCorrection;
		}
    }

	int countLiveCells(int[][] board, int r, int c, int[] correction) {
		//좌상/상/우상/우/우하/하/좌하/좌
		int[] rows =    {-1, -1, -1, 0, 1, 1,  1,  0};
		int[] columns = {-1,  0,  1, 1, 1, 0, -1, -1};

		int count = 0;
		for (int i = 0; i < 8; i++) {
			int row = r + rows[i];
			int column = c + columns[i];
			if (row >= 0 && row < board.length && column >= 0 && column < board[0].length) {
				count += board[row][column];
			}
		}
		count += correction[c];
		return count;
	}
}


//solution? use bit, space: O(1)
class Solution {
    public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				int lives = countLiveNeighbors(board, r, c);
				if (board[r][c] == 1 && lives >= 2 && lives <= 3) {
					board[r][c] = 3;
				}
				if (board[r][c] == 0 && lives == 3) {
					board[r][c] = 2;
				}
			}
		}
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] >>= 1;
			}
		}
	}

	int countLiveNeighbors(int[][] board, int r, int c) {
		//좌상/상/우상/우/우하/하/좌하/좌
		int[] rows =    {-1, -1, -1, 0, 1, 1,  1,  0};
		int[] columns = {-1,  0,  1, 1, 1, 0, -1, -1};

		int count = 0;
		for (int i = 0; i < 8; i++) {
			int row = r + rows[i];
			int column = c + columns[i];
			if (row >= 0 && row < board.length && column >= 0 && column < board[row].length) {
				count += board[row][column] & 1;
			}
		}
		return count;
	}
}






























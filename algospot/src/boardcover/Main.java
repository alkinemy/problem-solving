package boardcover;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int row = scanner.nextInt();
			int column = scanner.nextInt();
			boolean[][] board = new boolean[row][column];
			int whiteCellCount = 0;
			for (int r = 0; r < row; r++) {
				String boardRow = scanner.next();
				for (int c = 0; c < column; c++) {
					//white: false, black: true
					board[r][c] = boardRow.charAt(c) == '#';
					if (!board[r][c]) {
						whiteCellCount++;
					}
				}
			}
			if (whiteCellCount % 3 != 0) {
				System.out.println(0);
			} else {
				int count = solve(board, 0, 0);
				System.out.println(count);
			}
		}
	}

	static final int[][][] TYPES = {
		{ {0, 0}, {0, 1}, {1, 1} },
		{ {0, 0}, {0, 1}, {1, 0} },
		{ {0, 0}, {1, 0}, {1, 1} },
		{ {0, 0}, {1, 0}, {1, -1} }
	};

	private static int solve(boolean[][] board, int r, int c) {
		if (isBoardCovered(board)) {
			return 1;
		}

		if (r >= board.length) {
			return 0;
		}
		if (c >= board[0].length) {
			int nextR = r + 1;
			int nextC = 0;
			return solve(board, nextR, nextC);
		}

		if (board[r][c]) {
			int nextR = c == board[0].length - 1 ? r + 1 : r;
			int nextC = c == board[0].length - 1 ? 0 : c + 1;
			return solve(board, nextR, nextC);
		}

		int count = 0;
		for (int i = 0; i < TYPES.length; i++) {
			int[][] type = TYPES[i];
			if (canSet(board, r, c, type)) {
				mark(board, r, c, type);
				int nextR = c == board[0].length - 1 ? r + 1 : r;
				int nextC = c == board[0].length - 1 ? 0 : c + 1;
				count += solve(board, nextR, nextC);
				unmark(board, r, c, type);
			}
		}
		return count;
	}

	private static boolean isBoardCovered(boolean[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (!board[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void mark(boolean[][] board, int r, int c, int[][] type) {
		setValue(board, r, c, type, true);
	}

	private static void unmark(boolean[][] board, int r, int c, int[][] type) {
		setValue(board, r, c, type, false);
	}

	private static void setValue(boolean[][] board, int r, int c, int[][] type, boolean value) {
		for (int j = 0; j < 3; j++) {
			int row = r + type[j][0];
			int column = c + type[j][1];
			if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
				continue;
			}
			board[row][column] = value;
		}
	}

	private static boolean canSet(boolean[][] board, int r, int c, int[][] type) {
		for (int j = 0; j < 3; j++) {
			int row = r + type[j][0];
			int column = c + type[j][1];
			if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) {
				return false;
			}
			if (board[row][column]) {
				return false;
			}
		}
		return true;
	}

}

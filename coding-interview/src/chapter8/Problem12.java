

void findAllPositionsOfQueens(int column, int[][] board) {
	if (column >= board.length) {
		printQueenPosition(board);
		return;
	}

	for (int row = 0; row < board.length; row++) {
		if (board[row][column] == 0) {
			markPathOfQueen(row, column, board, 1);
			findAllPositionsOfQueens(column + 1, board);
			markPathOfQueen(row, column, board, -1);
		}
	}
}

void markPathOfQueen(int row, int column, int[][] board, int delta) {
	for (int i = 0; i < board.length; i++) {
		if (i == row) {
			continue;
		}
		board[i][column] = board[i][column] + delta;
	}
	for (int i = 0; i < board[0].length; i++) {
		if (i == column) {
			continue;
		}
		board[row][i] = board[row][i] + delta;
	}
	for (int i = 0; i < board.length; i++) {
		int r = row - column + i;
		if (r < 0 || r == row || r >= board[0].length) {
			continue;
		}
		board[r][i] = board[r][i] + delta;
	}
	for (int i = 0; i < board[0].length; i++) {
		int r = row + column - i;
		if (r < 0 || r == row || r >= board[0].length) {
			continue;
		}
		board[r][i] = board[r][i] + delta;
	}
}

void printQueenPosition(int[][] board) {
	for (int row = 0; row < board.length; row++) {
		for (int column = 0; row < board[0].length; column++) {
			char mark = board[row][column] == 0 ? 'O' : 'X'
			System.out.print(mark + " ");
		}
		System.out.println();
	}
	System.out.println("===============");
}

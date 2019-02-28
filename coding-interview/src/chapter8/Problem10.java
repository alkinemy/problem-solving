
enum Color {
	BLACK,
	WHITE,
	RED,
	YELLOW
}


void paintFill(Color[][] screen, Color fromColor, Color toColor, int row, int column) {
	if (row < 0 || column < 0 || row >= screen.length || column >= screen[0].length) {
		return;
	}

	Color originalColor = screen[row][column];
	if (originalColor == fromColor) {
		screen[row][column] = toColor;
		paintFill(screen, fromColor, toColor, row + 1, column);
		paintFill(screen, fromColor, toColor, row - 1, column);
		paintFill(screen, fromColor, toColor, row, column + 1);
		paintFill(screen, fromColor, toColor, row, column - 1);
	}
}



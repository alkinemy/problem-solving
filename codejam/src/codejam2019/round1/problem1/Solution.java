package codejam2019.round1.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			List<Point> result = solve(r, c);
			if (result.isEmpty()) {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + (i + 1) + ": POSSIBLE");
				for (Point point : result) {
					System.out.println((point.r + 1) + " " + (point.c + 1));
				}
			}
		}

	}

	private static List<Point> solve(int row, int column) {
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				List<Point> points = new ArrayList<>();
				boolean[][] visited = new boolean[row][column];
				if (solve(r, c, visited, points)) {
					return points;
				}
			}
		}
		return Collections.emptyList();
	}

	private static boolean solve(int row, int column, boolean[][] visited, List<Point> points) {
		if (visited[row][column]) {
			return false;
		}

		visited[row][column] = true;
		Point current = new Point(row, column);
		points.add(current);

		if (points.size() == (visited.length * visited[0].length)) {
			return true;
		}

		for (int r = 0; r < visited.length; r++) {
			for (int c = 0; c < visited[0].length; c++) {
				if (!visited[r][c] && isAvailablePoint(row, column, r, c)) {
					if (solve(r, c, visited, points)) {
						return true;
					}
				}
			}
		}
		visited[row][column] = false;
		points.remove(current);
		return false;
	}

	private static boolean isAvailablePoint(int fromRow, int fromColumn, int toRow, int toColumn) {
		if (fromRow == toRow) {
			return false;
		}
		if (fromColumn == toColumn) {
			return false;
		}
		if (fromRow - fromColumn == toRow - toColumn) {
			return false;
		}
		if (fromRow + fromColumn == toRow + toColumn) {
			return false;
		}
		return true;
	}

}


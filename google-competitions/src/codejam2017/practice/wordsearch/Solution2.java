package codejam2017.practice.wordsearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution2 {

	static char[][] fulls = new char[][] {
		{'I', '/', 'O'},
		{'/', 'I'},
		{'/', 'O'},
		{'O', '/', 'I'},
	};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		char[][][] results = new char[testCount][][];
		for(int i = 0; i < testCount; i++) {
			int dimension = scanner.nextInt();
			int n = scanner.nextInt();

			char[][] result = solve(dimension, n);
			results[i] = result;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + (i + 1));
			char[][] grid = results[i];
			for (int j = 0 ; j < grid.length; j++) {
				char[] row = grid[j];
				for (int k = 0; k < row.length; k++) {
					System.out.print(row[k]);
				}
				System.out.println(" line" + (j + 1));
//				System.out.println();
			}
		}
	}

	private static char[][] solve(int dimension, int n) {
		if (n == 0) {
			char[][] grid = new char[1][1];
			grid[0][0] = 'I';
			return grid;
		}
		if (n <= dimension) {
			char[][] grid = new char[n][];
			char[] fixed;
			for (int i = 0; i < n; i++) {
				if ((i / 2) % 2 == 0) {
					fixed = fulls[0];
				} else {
					fixed = fulls[3];
				}
				grid[i] = fixed;
			}
			return grid;
		}

		int repeat = n / dimension;
		int rest = n % dimension;
		int rowSize = repeat == 0 ? rest : dimension;
		int columnSize = 3 + repeat * 2;
		char[][] grid = new char[rowSize][columnSize];

		int columnStart = 0;
		for (int i = 0; i < repeat; i++) {
//			char[] fixed;
//			if (i == 0) {
//				fixed = fulls[0];
//			} else if (i % 2 == 1) {
//				fixed = fulls[1];
//			} else {
//				fixed = fulls[2];
//			}

			int length = i == 0 ? 3 : 2;

			for (int j = 0; j < dimension; j++) {
				char[] fixed;
				if (i == 0) {
					if ((j / 2) % 2 == 0) {
						fixed = fulls[0];
					} else {
						fixed = fulls[3];
					}
				} else {
					if ((j / 2) % 2 == 0) {
						fixed = fulls[2];
					} else {
						fixed = fulls[1];
					}
				}

				for (int k = 0; k < length; k++) {
					grid[j][columnStart + k] = fixed[k];
				}
			}
			columnStart += length;
		}

		char[] fixed;
		if (repeat % 2 == 1) {
			fixed = fulls[1];
		} else {
			fixed = fulls[2];
		}

		for (int j = 0; j < fixed.length; j++) {
			for (int k = 0; k < rest; k++) {
				grid[k][columnStart + j] = fixed[j];
			}
		}

		for (int j = 0; j < fixed.length; j++) {
			for (int k = rest; k < dimension; k++) {
				grid[k][columnStart + j] = fixed[fixed.length - 1];
			}
		}

		return grid;
	}
}

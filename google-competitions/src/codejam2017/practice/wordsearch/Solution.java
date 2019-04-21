package codejam2017.practice.wordsearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	static String[][] firstFull = new String[][]
		{
			{"O", "O", "O", "O", "O"},
			{"O", "/", "/", "/", "O"},
			{"O", "/", "I", "/", "O"},
			{"O", "/", "/", "/", "O"},
			{"O", "O", "O", "O", "O"},
		};

	static String[][] nextFull = new String[][]
		{
			{"O", "O", "O", "O"},
			{"/", "/", "/", "O"},
			{"/", "I", "/", "O"},
			{"/", "/", "/", "O"},
			{"O", "O", "O", "O"},
		};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		String[][][] results = new String[testCount][][];
		for(int i = 0; i < testCount; i++) {
			int dimension = scanner.nextInt();
			int n = scanner.nextInt();

			String[][] result = solve(dimension, n);
			results[i] = result;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + (i + 1));
			String[][] grid = results[i];
			for (int j = 0 ; j < grid.length; j++) {
				String[] row = grid[j];
				for (int k = 0; k < row.length; k++) {
					System.out.print(row[k]);
				}
				System.out.println();
			}
		}
	}

	private static String[][] solve(int dimension, int n) {
		if (n == 0) {
			String[][] grid = new String[1][1];
			grid[0][0] = "I";
			return grid;
		}
		if (n <= dimension) {
			String[][] grid = new String[n][];
			String[] fixed = new String[] {"I", "/", "O"};
			for (int i = 0; i < n; i++) {
				grid[i] = fixed;
			}
			return grid;
		}
		//column: 12개까지 가능
		//row: 12개까지 가능
		int count = n / 8;
		int lack = n % 8;

		if (count <= 12) {
			int columnSize = 5 + (count - 1) * 4;
			String[][] grid = new String[5][columnSize];
			//first object;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					grid[i][j] = firstFull[i][j];
				}
			}

			for (int j = 0; j < 5; j++) {
				for (int i = 5; i < 5 + (count - 1) * 4; i++) {
					grid[j][i] = nextFull[j][(i - 5) % 4];
				}
			}
			return grid;
		}
		return null;
	}
}

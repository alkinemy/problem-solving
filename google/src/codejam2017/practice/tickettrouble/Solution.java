package codejam2017.practice.tickettrouble;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		int[] results = new int[testCount];
		for(int i = 0; i < testCount; i++) {
			int friends = scanner.nextInt();
			int size = scanner.nextInt();
			int[][] seats = new int[friends][size];
			for (int f = 0; f < friends; f++) {
				seats[f][0] = scanner.nextInt();
				seats[f][1] = scanner.nextInt();
			}

			int result = solve(seats);
			results[i] = result;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + (i + 1) + ": " + results[i]);
		}
	}

	private static int solve(int[][] seats) {
		Map<String, Boolean> duplicate = new HashMap<>();
		Map<Integer, Integer> result = new HashMap<>();
		int max = 0;
		for (int j = 0; j < seats.length; j++) {
			int row = seats[j][0];
			int column = seats[j][1];
			String dup = row + String.valueOf(column);
			if (duplicate.get(dup) != null) {
				continue;
			} else {
				duplicate.put(dup, Boolean.TRUE);
			}
			if (row == column) {
				int count = result.getOrDefault(row, 0) + 1;
				if (max < count) {
					max = count;
				}
				result.put(row, count);
				continue;
			}
			int rowCount = result.getOrDefault(row, 0) + 1;
			if (max < rowCount) {
				max = rowCount;
			}
			result.put(row, rowCount);

			int columnCount = result.getOrDefault(column, 0) + 1;
			if (max < columnCount) {
				max = columnCount;
			}
			result.put(column, columnCount);
		}
		return max;
	}

}

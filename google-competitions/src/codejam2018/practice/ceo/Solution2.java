package codejam2018.practice.ceo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		long[] results = new long[testCount];
		for(int i = 0; i < testCount; i++) {
			int levelCount = scanner.nextInt();

			long[][] levels = new long[levelCount][2];
			for (int j = 0; j < levelCount; j++) {
				levels[j][0] = scanner.nextLong(); //the number of people
				levels[j][1] = scanner.nextLong(); //level
			}
			long result = solve(levels);
			results[i] = result;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + (i + 1) + ": " + results[i]);
		}

	}

	private static long solve(long[][] levels) {
		long minimumCeoLevel = levels[levels.length - 1][1] + 1;
		long cannotHandle = levels[levels.length - 1][0];
		long room = 0;
		for (int i = levels.length - 1; i > 0; i--) {
			long[] upper = levels[i];
			long[] lower = levels[i - 1];
			long difference = ((upper[0] * upper[1]) + room) - lower[0];
			if (difference >= 0) {
				room = difference;
			} else {
				cannotHandle += (-difference);
			}
		}
		if (cannotHandle <= minimumCeoLevel) {
			return minimumCeoLevel;
		}
		return cannotHandle;

	}
}

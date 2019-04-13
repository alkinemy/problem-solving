package codejam2018.practice.ceo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static class Experience {
		int number;
		int level;

		public Experience(int number, int level) {
			this.number = number;
			this.level = level;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		int[] results = new int[testCount];
		for(int i = 0; i < testCount; i++) {
			int levelCount = scanner.nextInt();

			List<Experience> experiences = new ArrayList<>();
			for (int j = 0; j < levelCount; j++) {
				int number = scanner.nextInt(); //number of people
				int level = scanner.nextInt(); //level
				experiences.add(new Experience(number, level));
			}
			experiences.sort(Comparator.comparingInt(e -> e.level));
			int result = solve(experiences);
			results[i] = result;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + (i + 1) + ": " + results[i]);
		}

	}

	private static int solve(List<Experience> experiences) {
		Experience highest = experiences.get(experiences.size() - 1);
		int minimumCeoLevel = highest.level + 1;
		int cannotHandle = highest.number;
		int room = 0;
		for (int i = experiences.size() - 1; i > 0; i--) {
			Experience upper = experiences.get(i);
			Experience lower = experiences.get(i - 1);
			int difference = ((upper.number * upper.level) + room) - lower.number;
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

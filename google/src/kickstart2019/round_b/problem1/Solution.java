package kickstart2019.round_b.problem1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Solution {

	static class Question {
		int from;
		int to;

		public Question(int from, int to) {
			this.from = from;
			this.to = to;
		}

		@Override public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Question question = (Question) o;
			return from == question.from &&
				to == question.to;
		}

		@Override public int hashCode() {
			return Objects.hash(from, to);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int letterSize = scanner.nextInt();
			int questionSize = scanner.nextInt();
			char[] letters = scanner.next().toCharArray();
			Question[] questions = new Question[questionSize];
			for (int j = 0; j < questionSize; j++) {
				questions[j] = new Question(scanner.nextInt() - 1, scanner.nextInt() - 1);
			}
			int counts = solve(letters, questions);
			System.out.println("Case #" + (i + 1) + ": " + counts);
		}
	}

	private static int solve(char[] letters, Question[] questions) {
		int result = 0;
		Map<Question, Integer> resultMemo = new HashMap<>();
		for (int i = 0; i < questions.length; i++) {
			if (resultMemo.containsKey(questions[i])) {
				result += resultMemo.get(questions[i]);
			} else {
				int count = canMakePalindrome(letters, questions[i]) ? 1 : 0;
				resultMemo.put(questions[i], count);
				result += count;
			}
		}
		return result;
	}

	private static boolean canMakePalindrome(char[] letters, Question question) {
		if (question.from == question.to) {
			return true;
		}
		Map<Character, Integer> counts = new HashMap<>();
		for (int i = question.from; i <= question.to; i++) {
			int count = counts.getOrDefault(letters[i], 0) + 1;
			counts.put(letters[i], count);
		}
		boolean oddShown = false;
		for (int count : counts.values()) {
			if (count % 2 == 1) {
				if (oddShown) {
					return false;
				}
				oddShown = true;
			}
		}
		return true;
	}
}

package quadtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			String tree = scanner.next();
			System.out.println(reverse(tree));
		}
	}

	private static String reverse(String tree) {
		if (tree.length() == 1) {
			return tree;
		}

		String[] parts = splitParts(tree);
		String firstReversedPart = reverse(parts[0]);
		String secondReversedPart = reverse(parts[1]);
		String thirdReversedPart = reverse(parts[2]);
		String fourthReversedPart = reverse(parts[3]);

		return "x" + thirdReversedPart + fourthReversedPart + firstReversedPart + secondReversedPart;
	}

	private static String[] splitParts(String tree) {
		int index = 1;
		int read = 1;

		int partIndex = 0;
		int partStart = 1;
		String[] parts = new String[4];
		while (index < tree.length()) {
			read--;
			if (tree.charAt(index) == 'x') {
				read += 4;
			} else if (read == 0) {
				parts[partIndex] = tree.substring(partStart, index + 1);
				partStart = index + 1;
				partIndex++;
				read = 1;
			}
			index++;
		}
		return parts;
	}

}

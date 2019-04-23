package quadtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main2 {
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

		String[] parts = getReversedParts(tree);

		return "x" + parts[2] + parts[3] + parts[0] + parts[1];
	}

	private static String[] getReversedParts(String tree) {
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
				parts[partIndex] = reverse(tree.substring(partStart, index + 1));
				partStart = index + 1;
				partIndex++;
				read = 1;
			}
			index++;
		}
		return parts;
	}

}

package quadtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Book {

	public static class Result {
		String reversed;
		int nextIndex;

		public Result(String reversed, int nextIndex) {
			this.reversed = reversed;
			this.nextIndex = nextIndex;
		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			String tree = scanner.next();
			System.out.println(reverse(tree, 0).reversed);
		}
	}

	private static Result reverse(String tree, int index) {
		char c = tree.charAt(index);

		if (c == 'b' || c == 'w') {
			return new Result(String.valueOf(c), index + 1);
		}
		Result upperLeft = reverse(tree, index + 1);
		Result upperRight = reverse(tree, upperLeft.nextIndex);
		Result lowerLeft = reverse(tree, upperRight.nextIndex);
		Result lowerRight = reverse(tree, lowerLeft.nextIndex);
		return new Result("x" + lowerLeft.reversed + lowerRight.reversed + upperLeft.reversed + upperRight.reversed, lowerRight.nextIndex);
	}

}

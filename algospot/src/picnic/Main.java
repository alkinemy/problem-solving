package picnic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int n = scanner.nextInt();
			int pairCount = scanner.nextInt();
			List<List<Integer>> pairs = new ArrayList<>();
			for (int j = 0; j < pairCount; j++) {
				int f1 = scanner.nextInt();
				int f2 = scanner.nextInt();
				List<Integer> friends = new ArrayList<>();
				friends.add(f1);
				friends.add(f2);
				pairs.add(friends);
			}
			System.out.println(countPairs(n, 0, pairs, new HashSet<>()));
		}
	}

	private static int countPairs(int n, int index, List<List<Integer>> pairs, Set<Integer> result) {
		if (n == result.size()) {
			return 1;
		}

		int available = 0;
		for (int i = index; i < pairs.size(); i++) {
			List<Integer> pair = pairs.get(i);
			int f1 = pair.get(0);
			int f2 = pair.get(1);
			if (result.contains(f1) || result.contains(f2)) {
				continue;
			}
			result.add(f1);
			result.add(f2);
			available += countPairs(n, i + 1, pairs, result);
			result.remove(f1);
			result.remove(f2);
		}
		return available;
	}
}

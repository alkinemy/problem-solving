package picnic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Book {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int n = scanner.nextInt();
			int pairCount = scanner.nextInt();
			boolean[][] friends = new boolean[n][n];
			for (int j = 0; j < pairCount; j++) {
				int f1 = scanner.nextInt();
				int f2 = scanner.nextInt();
				friends[f1][f2] = true;
				friends[f2][f1] = true;
			}
			System.out.println(countPairs(friends, new boolean[n]));
		}
	}

	//전부 다 친구인 경우에---
	//완성되는 시점에 countPairs가 호출되는 수: (2n-1)!
	//중간에 countPairs가 호출되는 수: root에서 말단까지의 거리가 n/2 -> 전체 노드는 (n/2)*(2n-1)!을 넘지 못함
	//전부 할당되었는지 체크: n
	//conclusion: O(n^2*(2n-1)!) ???
	private static int countPairs(boolean[][] friends, boolean[] used) {
		int notUsed = -1;
		for (int i = 0; i < used.length; i++) {
			if (!used[i]) {
				notUsed = i;
				break;
			}
		}
		if (notUsed == -1) {
			return 1;
		}

		int count = 0;
		for (int pair = notUsed + 1; pair < used.length; pair++) {
			if (friends[notUsed][pair] && !used[pair]) {
				used[pair] = true;
				used[notUsed] = true;
				count += countPairs(friends, used);
				used[notUsed] = false;
				used[pair] = false;
			}
		}
		return count;
	}
}

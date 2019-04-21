package kickstart2019.round_b.problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int trinketCount = scanner.nextInt();
			int limit = scanner.nextInt();
			int[] trinkets = new int[trinketCount];
			for (int j = 0; j < trinketCount; j++) {
				trinkets[j] = scanner.nextInt();
			}
			int max = solve(trinkets, limit);
			System.out.println("Case #" + (i + 1) + ": " + max);
		}
	}

	private static int solve(int[] trinkets, int limit) {
		int result = Integer.MIN_VALUE;

		for (int from = 0; from < trinkets.length; from++) {
			Map<Integer, Integer> types = new HashMap<>();
			int current = 0;
			for (int to = from; to < trinkets.length; to++) {
				if (types.containsKey(trinkets[to])) {
					if (types.get(trinkets[to]) == null) {
						continue;
					}
					int count = types.get(trinkets[to]);
					if (count + 1 > limit) {
						current -= count;
						types.put(trinkets[to], null);
					} else {
						types.put(trinkets[to], count + 1);
						current++;
					}
				} else {
					types.put(trinkets[to], 1);
					current++;
				}
				result = Math.max(result, current);
			}
		}
		return result;
	}

}

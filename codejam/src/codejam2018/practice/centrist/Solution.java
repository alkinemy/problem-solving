package codejam2018.practice.centrist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		String[] results = new String[testCount];
		for (int i = 0; i < testCount; i++) {
			int letterCount = scanner.nextInt();
			String str1 = scanner.next();
			String str2 = scanner.next();
			String str3 = scanner.next();

			String result = solve(i + 1, letterCount, str1, str2, str3);
			results[i] = result;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}

	private static String solve(int testNumber, int letterCount, String str1, String str2, String str3) {
		Map<String, Integer> indexes = new HashMap<>();
		indexes.put(str1, 0);
		indexes.put(str2, 1);
		indexes.put(str3, 2);
		Map<Character, Boolean> seen = new HashMap<>();
		String[] result = new String[] {"NO", "NO", "NO"};
		int i = 0;
		String else1 = null;
		String else2 = null;
		char before = '-';
		for (; i < letterCount; i++) {
			Map<Character, Integer> counter = new HashMap<>();
			char str1Char = str1.charAt(i);
			counter.put(str1Char, counter.getOrDefault(str1Char, 0) + 1);
			seen.put(str1Char, Boolean.TRUE);
			char str2Char = str2.charAt(i);
			counter.put(str2Char, counter.getOrDefault(str2Char, 0) + 1);
			seen.put(str2Char, Boolean.TRUE);
			char str3Char = str3.charAt(i);
			counter.put(str3Char, counter.getOrDefault(str3Char, 0) + 1);
			seen.put(str3Char, Boolean.TRUE);

			Set<Character> keys = counter.keySet();
			if (keys.size() == 3) {
				return "Case #" + testNumber + ": YES YES YES";
			}
			if (keys.size() == 1) {
				continue;
			}

			Character once = null;
			for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
				if (entry.getValue() == 1) {
					once = entry.getKey();
					break;
				}
			}
			if (str1Char == once) {
				else1 = str2;
				else2 = str3;
				before = str1Char;
			} else if (str2Char == once) {
				else1 = str1;
				else2 = str3;
				before = str2Char;
			} else {
				else1 = str1;
				else2 = str2;
				before = str3Char;
			}
			break;
		}

		if (i == letterCount) {
			return "Case #" + testNumber + ": NO NO NO";
//			return "Case #" + testNumber + ": " + result[0] + " " + result[1] + " " + result[2];
		}

		for (i = i + 1; i < letterCount; i++) {
			Map<Character, Integer> counter = new HashMap<>();
			char else1Char = else1.charAt(i);
			counter.put(else1Char, counter.getOrDefault(else1Char, 0) + 1);
			char else2Char = else2.charAt(i);
			counter.put(else2Char, counter.getOrDefault(else2Char, 0) + 1);

			Set<Character> keys = counter.keySet();
			if (keys.size() == 2) {
				if (else1Char == before) {
					result[indexes.get(else1)] = "YES";
					if (seen.get(else2Char) != null) {
						result[indexes.get(else2)] = "NO";
					} else {
						result[indexes.get(else2)] = "YES";
					}
					break;
				} else if (else2Char == before) {
					result[indexes.get(else2)] = "YES";
					if (seen.get(else1Char) != null) {
						result[indexes.get(else1)] = "NO";
					} else {
						result[indexes.get(else1)] = "YES";
					}
					break;
				} else {
					result[indexes.get(else1)] = "YES";
					result[indexes.get(else2)] = "YES";
					break;
				}

			}
			if (keys.size() == 1) {
				continue;
			}
		}

		return "Case #" + testNumber + ": " + result[0] + " " + result[1] + " " + result[2];
	}

}

package codejam2018.practice.centrist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		String[] results = new String[testCount];
		List<Map<Character, Integer>> rules = populateRules();
		for (int i = 0; i < testCount; i++) {
			int letterCount = scanner.nextInt();
			String str1 = scanner.next();
			String str2 = scanner.next();
			String str3 = scanner.next();

			String result = solve(i + 1, letterCount, rules, str1, str2, str3);
			results[i] = result;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}

	private static String solve(int testNumber, int letterCount, List<Map<Character, Integer>> rules, String str1, String str2, String str3) {
		Map<String, String> result = new HashMap<>();
		result.put(str1, "NO");
		result.put(str2, "NO");
		result.put(str3, "NO");
		for(Map<Character, Integer> rule : rules) {
			result.put(getMiddle(rule, letterCount, str1, str2, str3), "YES");
		}
		return "Case #" + testNumber + ": " + result.get(str1) + " " + result.get(str2) + " " + result.get(str3);
	}

	private static String getMiddle(Map<Character, Integer> rule, int letterCount, String str1, String str2, String str3) {
		Map<String, String> byRule = createStringByRule(rule, letterCount, str1, str2, str3);
		List<String> ordered = new ArrayList<>(byRule.keySet());
		Collections.sort(ordered);
		return byRule.get(ordered.get(1));
	}

	private static Map<String, String> createStringByRule(Map<Character, Integer> rule, int letterCount, String str1, String str2, String str3) {
		StringBuilder sb1 = new StringBuilder(letterCount);
		StringBuilder sb2 = new StringBuilder(letterCount);
		StringBuilder sb3 = new StringBuilder(letterCount);
		for (int i = 0; i < letterCount; i++) {
			sb1.append(rule.get(str1.charAt(i)));
			sb2.append(rule.get(str2.charAt(i)));
			sb3.append(rule.get(str3.charAt(i)));
		}
		Map<String, String> result = new HashMap<>();
		result.put(sb1.toString(), str1);
		result.put(sb2.toString(), str2);
		result.put(sb3.toString(), str3);
		return result;
	}

	private static List<Map<Character, Integer>> populateRules() {
		List<Map<Character, Integer>> result = new ArrayList<>();
		{
			Map<Character, Integer> rule = new HashMap<>();
			rule.put('A', 1);
			rule.put('B', 2);
			rule.put('C', 3);
			result.add(rule);
		}
		{
			Map<Character, Integer> rule = new HashMap<>();
			rule.put('A', 1);
			rule.put('B', 3);
			rule.put('C', 2);
			result.add(rule);
		}
		{
			Map<Character, Integer> rule = new HashMap<>();
			rule.put('A', 2);
			rule.put('B', 1);
			rule.put('C', 3);
			result.add(rule);
		}
		{
			Map<Character, Integer> rule = new HashMap<>();
			rule.put('A', 2);
			rule.put('B', 3);
			rule.put('C', 1);
			result.add(rule);
		}
		{
			Map<Character, Integer> rule = new HashMap<>();
			rule.put('A', 3);
			rule.put('B', 1);
			rule.put('C', 2);
			result.add(rule);
		}
		{
			Map<Character, Integer> rule = new HashMap<>();
			rule.put('A', 3);
			rule.put('B', 2);
			rule.put('C', 1);
			result.add(rule);
		}
		return result;
	}

}

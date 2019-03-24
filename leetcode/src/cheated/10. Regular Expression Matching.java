/**
 * https://leetcode.com/problems/regular-expression-matching/
 */

//solution1(recursion)
class Solution {
    public boolean isMatch(String text, String pattern) {
		if (pattern.length() == 0) {
			return text.length() == 0;
		}
		boolean firstMatch = !(text.length() == 0) && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');
		if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
			return isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
		}
		return firstMatch && isMatch(text.substring(1), pattern.substring(1));
	}
}

//solution2(DP) - Top-down
class Solution {
    public boolean isMatch(String text, String pattern) {
		Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];
		return doIsMatch(0, 0, text, pattern, memo);
	}

	boolean doIsMatch(int ti, int pi, String text, String pattern, Boolean[][] memo) {
		if (memo[ti][pi] != null) {
			return memo[ti][pi];
		}
		if (pi == pattern.length()) {
			memo[ti][pi] = ti == text.length();
			return memo[ti][pi];
		}

		boolean firstMatch = ti < text.length() && (pattern.charAt(pi) == text.charAt(ti) || pattern.charAt(pi) == '.');
		if (pi + 1 < pattern.length() && pattern.charAt(pi + 1) == '*') {
			memo[ti][pi] = doIsMatch(ti, pi + 2, text, pattern, memo) || (firstMatch && doIsMatch(ti + 1, pi, text, pattern, memo));
			return memo[ti][pi];
		}
		memo[ti][pi] = firstMatch && doIsMatch(ti + 1, pi + 1, text, pattern, memo);
		return memo[ti][pi];
	}
}

//solution3(DP) - Bottom-up
class Solution {
    public boolean isMatch(String text, String pattern) {
		boolean[][] memo = new boolean[text.length() + 1][pattern.length() + 1];
		memo[text.length()][pattern.length()] = true;

		for (int ti = text.length(); ti >= 0; ti--) {
			for (int pi = pattern.length() - 1; pi >= 0; pi--) {
				boolean firstMatch = ti < text.length() && (pattern.charAt(pi) == text.charAt(ti) || pattern.charAt(pi) == '.');
				if (pi + 1 < pattern.length() && pattern.charAt(pi + 1) == '*') {
					memo[ti][pi] = memo[ti][pi + 2] || (firstMatch && memo[ti + 1][pi]);
				} else {
					memo[ti][pi] = firstMatch && memo[ti + 1][pi + 1];
				}
			}
		}
		return memo[0][0];
	}
}

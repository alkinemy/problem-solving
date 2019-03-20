/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */

//DP (solution)
class Solution {
	public String longestPalindrome(String s) {
		if (s == null || "".equals(s)) {
			return s;
		}
		int[][] array = new int[s.length()][s.length()];
		int maxStart = 0;
		int maxEnd = 0;
		int max = 1;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				int start = j;
				int end = j + i;
				if (end >= s.length()) {
					break;
				}
				if (start == end) {
					array[start][end] = 1;
				} else if (end - start == 1) {
					if (s.charAt(start) == s.charAt(end)) {
						array[start][end] = 2;
					}
				} else {
					int pStart = start + 1;
					int pEnd = end - 1;
					if (s.charAt(start) == s.charAt(end) && array[pStart][pEnd] != 0) {
						array[start][end] = array[pStart][pEnd] + 2;
					} else {
						array[start][end] = 0;
					}
				}

				if (array[start][end] > max) {
					max = array[start][end];
					maxStart = start;
					maxEnd = end;
				}

			}
		}
		return s.substring(maxStart, maxEnd + 1);
	}
}



//expand around center(solution)
class Solution {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		int start = 0;
		int end = 0;
		int max = 1;
		for(int i = 0; i < s.length(); i++) {
			int palindromeLength1 = getPalindromeLength(s, i, i);
			int palindromeLength2 = getPalindromeLength(s, i, i + 1);
			int currentMax = Math.max(palindromeLength1, palindromeLength2);
	
			if (currentMax > max) {
				max = currentMax;
				start = i - (max - 1) / 2;
				end = i + max / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	int getPalindromeLength(String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return end - start - 1;
	}
}

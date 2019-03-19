/**
 * https://leetcode.com/problems/generate-parentheses/
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }

		List<String> brackets = new ArrayList<>();
		generateBrackets("", n, n, brackets);
		return brackets;
    }

	void generateBrackets(String str, int open, int close, List<String> brackets) {
		if (open < 0 || close < 0 || close < open) {
			return;
		}
		if (open == 0 && close == 0) {
			brackets.add(str);
			return;
		}
		
		generateBrackets(str + "(", open - 1, close, brackets);
		generateBrackets(str + ")", open, close - 1, brackets);
		
	}
}

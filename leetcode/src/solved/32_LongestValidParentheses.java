/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */

class Solution {
    public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> lengths = new Stack<>();
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push('(');
			} else if (c == ')') {
				if (stack.isEmpty()) {
					continue;
				}
				int length = 0;
				while(!stack.isEmpty()) {
					char popped = stack.pop();
					if (popped == '-') {
						length += lengths.pop();
					} else {
						length += 2;
						break;
					}
				}
				while(!stack.isEmpty()) {
					char popped = stack.pop();
					if (popped == '-') {
						length += lengths.pop();
					} else {
						stack.push(popped);
						break;
					}
				}
				lengths.push(length);
				stack.push('-');
			}
		}

		int result = 0;
		while(!lengths.isEmpty()) {
			result = Math.max(result, lengths.pop());
		}
		return result;
    }
}

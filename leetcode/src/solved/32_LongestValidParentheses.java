/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */

//first answer
class Solution {
    public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// ( = -1
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(-1);
			} else { // ')'
				int length = 0;
				boolean found = false;
				while(!stack.isEmpty()) {
					int popped = stack.pop();
					if (popped == -1) {
						length += 2;
						found = true;
						break;
					} else {
						length += popped;
					}
				}
				if (found) {
					stack.push(length);
				} else {
					result = Math.max(result, length);
				}
			}
		}
		
        int current = 0;
        while(!stack.isEmpty()) {
            int length = stack.pop();
            if (length == -1) {
                result = Math.max(result, current);
                current = 0;
            } else {
                current += length;
            }
        }
        return Math.max(result, current);
    }
}

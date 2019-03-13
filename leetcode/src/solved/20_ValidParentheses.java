/**
 * https://leetcode.com/problems/valid-parentheses/
 */

class Solution {
    public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> pairs = new HashMap<>();
		pairs.put(')', '(');
		pairs.put('}', '{');
		pairs.put(']', '[');

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isOpenBrace(c)) {
				stack.push(c);
				continue;
			}

			//close brace appeared
			if (stack.isEmpty()) {
				return false;
			}
			char openBrace = stack.pop();
			if (!isOpenBrace(openBrace)) {
				return false;
			}

			if (pairs.get(c) != openBrace) {
				return false;
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
    }

	boolean isOpenBrace(char c) {
		return c == '(' || c == '{' || c == '[';
	}

}

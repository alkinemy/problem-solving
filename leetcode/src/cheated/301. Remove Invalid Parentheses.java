/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 */

//solution1
class Solution {

	private Set<String> result = new HashSet<>();
	private int minRemovedCount = Integer.MAX_VALUE;

	public List<String> removeInvalidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return Collections.singletonList("");
		}

		populateValidParentheses(s, 0, 0, 0, new StringBuilder(), 0);
		return new ArrayList<>(result);
	}

	void populateValidParentheses(String s, int index, int openCount, int closeCount, StringBuilder parentheses, int removedCount) {
		if (index == s.length()) {
			if (openCount == closeCount) {
				if (removedCount < minRemovedCount) {
					result.clear();
					result.add(parentheses.toString());
					minRemovedCount = removedCount;
				} else if (removedCount == minRemovedCount) {
					result.add(parentheses.toString());
				}
			}
			return;
		}

		char c = s.charAt(index);
		int cAt = parentheses.length();
		if (c != '(' && c != ')') {
			parentheses.append(c);
			populateValidParentheses(s, index + 1, openCount, closeCount, parentheses, removedCount);
			parentheses.deleteCharAt(cAt);
		} else {
			populateValidParentheses(s, index + 1, openCount, closeCount, parentheses, removedCount + 1);

			parentheses.append(c);
			if (c == '(') {
				populateValidParentheses(s, index + 1, openCount + 1, closeCount, parentheses, removedCount);
			} else if (closeCount < openCount) {
				populateValidParentheses(s, index + 1, openCount, closeCount + 1, parentheses, removedCount);
			}
			parentheses.deleteCharAt(cAt);
		}
	}
}



//solution2 - faster than solution1
class Solution {

	private Set<String> result = new HashSet<>();

	public List<String> removeInvalidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return Collections.singletonList("");
		}
		int leftRemove = 0;
		int rightRemove = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				leftRemove++;
			} else if (c == ')') {
				if (leftRemove == 0) {
					rightRemove++;
				} else {
					leftRemove--;
				}
			}
		}
		populateVaildParentheses(s, 0, 0, 0, leftRemove, rightRemove, new StringBuilder());
		return new ArrayList<>(result);
	}

	void populateValidParentheses(String s, int index, int leftCount, int rightCount, int leftRemove, int rightRemove, StringBuilder parentheses) {
		if (index == s.length()) {
			if (leftRemove == 0 && rightRemove == 0) {
				result.add(parentheses.toString());
			}
			return;
		}

		char c = s.charAt(index);
		int cAt = parentheses.length();
		if (c != '(' && c != ')') {
			parentheses.append(c);
			populateValidParentheses(s, index + 1, leftCount, rightCount, leftRemove, rightRemove, parentheses);
			parentheses.deleteCharAt(cAt);
			return;
		}
		if (c == '(') {
			if (leftRemove > 0) {
				populateValidParentheses(s, index + 1, leftCount, rightCount, leftRemove - 1, rightRemove, parentheses);
			}
			parentheses.append(c);
			populateValidParentheses(s, index + 1, leftCount + 1, rightCount, leftRemove, rightRemove, parentheses);
			parentheses.deleteCharAt(cAt);
		} else {
			if (rightRemove > 0) {
				populateValidParentheses(s, index + 1, leftCount, rightCount, leftRemove, rightRemove - 1, parentheses);
			}
			if (rightCount < leftCount) {
				parentheses.append(c);
				populateValidParentheses(s, index + 1, leftCount, rightCount + 1, leftRemove, rightRemove, parentheses);
				parentheses.deleteCharAt(cAt);
			}
		}
	}
}

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */

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




//brute force(solution)
//O(n^3), time limit exceeded
public class Solution {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j += 2) {
				if (isValid(s.substring(i, j))) {
					max = Math.max(max, j - i);
				}
			}
		}
		return max;
	}

	private boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}




//DP(solution)
public class Solution {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int max = 0;
		int[] memo = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			char current = s.charAt(i);
			if (current == ')') {
				char previous = s.charAt(i - 1);

				if (previous == '(') {
					int length = 0;
					if (i - 2 >= 0) {
						length = memo[i - 2];
					}
					memo[i] = length + 2;
				} else {
					int previousOpenBraceIndex = i - memo[i - 1] - 1;
					if (previousOpenBraceIndex >= 0) {
						if (s.charAt(previousOpenBraceIndex) == '(') {
							int length = 0;
							if (previousOpenBraceIndex - 1 >= 0) {
								length = memo[previousOpenBraceIndex - 1];
							}
							memo[i] = memo[i - 1] + length + 2;
						}
					}
				}
				max = Math.max(max, memo[i]);
			}
		}

		return max;
	}
}





//Stack(solution)
public class Solution {
    public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				int top = stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				}
				max = Math.max(max, i - stack.peek());
			}
		}
		return max;
	}
}






//without extra space
public class Solution {
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				max = Math.max(max, left * 2);
			} else if (right > left) {
				left = 0;
				right = 0;
			}
		}

		left = 0;
		right = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				max = Math.max(max, left * 2);
			} else if (left > right) {
				left = 0;
				right = 0;
			}
		}
		return max;
	}
}







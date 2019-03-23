/**
 * https://leetcode.com/problems/basic-calculator/
 */

//first answer
class Solution {
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		int start = 0;
		int end = 0;
		s = removeBlank(s);
		while(end < s.length()) {
			char c = s.charAt(end);
			if (c == '+' || c == '-') {
				if (start < end) {
					int operand = Integer.parseInt(s.substring(start, end));
					operands.push(operand);
				}
				operators.push(c);
				end++;
				start = end;
			} else if (c == '(') {
				operators.push(c);
				end++;
				start = end;
			} else if (c == ')') {
				if (start < end) {
					int operand = Integer.parseInt(s.substring(start, end));
					operands.push(operand);
				}
				int calculated = calculateUntilOpenBrace(operands, operators);
				operands.push(calculated);
				end++;
				start = end;
			} else {
				end++;
			}
		}
		if (start < end) {
			operands.push(Integer.parseInt(s.substring(start, end)));
		}

		if (operators.isEmpty()) {
			return operands.pop();
		} else {
			return calculateUntilOpenBrace(operands, operators);
		}
	}

	String removeBlank(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ' ') {
				continue;
			}
			sb.append(c);
		}
		return sb.toString();
	}

	int calculateUntilOpenBrace(Stack<Integer> operands, Stack<Character> operators) {
		if (operands.isEmpty()) {
			return 0;
		}
		int sum = operands.pop();
		while(!operators.isEmpty()) {
			char operator = operators.pop();
			if (operator == '(') {
				break;
			}
			int operand = 0;
			if (!operands.isEmpty()) {
				operand = operands.pop();
			}
			if (!operators.isEmpty() && operators.peek() == '-') {
				operators.pop();
				operand *= -1;
				operators.push('+');
			}
			sum = doCalculation(operator, operand, sum);
		}
		return sum;
	}

	int doCalculation(char operator, int fore, int back) {
		if (operator == '+') {
			return fore + back;
		} else {
			return fore - back;
		}
	}
}


//solution?
class Solution {
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Stack<Integer> results = new Stack<>();
		Stack<Integer> flags = new Stack<>();
		int result = 0;
		int flag = 1;
		int number = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				number = number * 10 + (c - '0');
			} else if (c == '+') {
				result += flag * number;
				flag = 1;
				number = 0;
			} else if (c == '-') {
				result += flag * number;
				flag = -1;
				number = 0;
			} else if (c == '(') {
				results.push(result);
				flags.push(flag);
				result = 0;
				flag = 1;
				number = 0;
			} else if (c == ')') {
				result += flag * number;
				result = results.pop() + flags.pop() * result;
				flag = 1;
				number = 0;
			}
		}
		result += flag * number;
		return result;
	}
}


//review
class Solution {
    public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0
		}

		Stack<Integer> calcuatedStack = new Stack<>();
		Stack<Integer> signStack = new Stack<>();
		int calculated = 0;
		int number = 0;
		int sign = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				number = number * 10 + (c - '0');
			} else if (c == '+') {
				calculated += sign * number;
				number = 0;
				sign = 1;
			} else if (c == '-') {
				calculated += sign * number;
				number = 0;
				sign = -1;
			} else if (c == '(') {
				calculatedStack.push(calculated);
				signStack.push(sign);
				calculated = 0;
				number = 0;
				sign = 1;
			} else if (c == ')') {
				calculated += sign * number;
				calculated = calculatedStack.pop() + signStack.pop() * calculated;
				number = 0;
				sign = 1;
			}
		}
		calculated += sign * number;
		return calculated;
	}
}




























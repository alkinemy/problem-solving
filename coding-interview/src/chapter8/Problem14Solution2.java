int countCaseOfBraces(String expression, boolean expected, Map<String, Integer> memo) {
	if (expression.length() == 0) {
		return 0;
	}
	
	if (expression.length() == 1) {
		if (getBit(expression) == expected) {
			return 1;
		}
		return 0;
	}
	
	if (memo.containsKey(expected + expression)) {
		return memo.get(expected + expression);
	}

	int count = 0;
	for (int i = 1; i < expression.length(); i += 2) {
		String left = expression.substring(0, i);
		String right = expression.substring(i + 1);

		char operator = expression.charAt(i);
		int leftTrue = countCaseOfBraces(left, true, memo);
		int leftFalse = countCaseOfBraces(left, false, memo);
		int rightTrue = countCaseOfBraces(right, true, memo);
		int rightFalse = countCaseOfBraces(right, false, memo);
		if (operator == '&') {
			if (expected == true) {
				count += leftTrue * rightTrue;
			} else {
				count += leftTrue * rightFalse;
				count += leftFalse * (rightTrue + rightFalse);
			}
		} else if (operator == '|') {
			if (expected == true) {
				count += leftTrue * (rightTrue + rightFalse);
				count += leftFalse * rightTrue;
			} else {
				count += leftFalse * rightFalse;
			}
		} else if (operator == '^') {
			if (expected == true) {
				count += leftTrue * rightFalse;
				count += leftFalse * rightTrue;
			} else {
				count += leftTrue * rightTrue;
				count += leftFalse * rightFalse;
			}
		}
	}
	memo.put(expected + expression, count);
	return count;
}

boolean getBit(String s) {
	if ("0".equals(s)) {
		return false;
	}
	return true;
}

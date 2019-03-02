

int countCaseOfBraces(String expression, boolean expected) {
	if (expression.length() == 0) {
		return 0;
	}
	
	if (expression.length() == 1) {
		if (getBit(expression) == expected) {
			return 1;
		}
		return 0;
	}

	int count = 0;
	for (int i = 1; i < expression.length(); i += 2) {
		String left = expression.substring(0, i);
		String right = expression.substring(i + 1);

		char operator = expression.charAt(i);
		int leftTrue = countCaseOfBraces(left, true);
		int leftFalse = countCaseOfBraces(left, false);
		int rightTrue = countCaseOfBraces(right, true);
		int rightFalse = countCaseOfBraces(right, false);
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
	return count;
}

boolean getBit(String s) {
	if ("0".equals(s)) {
		return false;
	}
	return true;
}

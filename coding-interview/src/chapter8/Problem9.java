List<String> buildBraces(int size) {
	List<String> result = new ArrayList<>();
	populateBraces(size, size, new char[size * 2], 0, result);
	return result;
}

void populateBraces(int leftSize, int rightSize, char[] braces, int index, List<String> result) {
	if (leftSize < 0 || rightSize < leftSize) {
		return;
	}

	if (leftSize == 0 && rightSize == 0)    {
		result.add(String.valueOf(braces));
		return;
	}

	braces[index] = '(';
	populateBraces(leftSize - 1, rightSize, braces, index + 1, result);
	braces[index] = ')';
	populateBraces(leftSize, rightSize - 1, braces, index + 1, result);
}

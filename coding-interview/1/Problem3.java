//URL화


//O(n)
char[] encode(char[] input, int length) {
	int encodedLength = calculateEncodedLength(input, length);
	int replacePivot = encodedLength - 1;
	for (int inputPivot = length - 1; inputPivot >= 0; inputPivot--) {
		char at = input[inputPivot];
		if (at == ' ') {
			input[replacePivot--] = '0';
			input[replacePivot--] = '2';
			input[replacePivot--] = '%';
		} else {
			input[replacePivot--] = at;
		}
	}
	return input;
}

int calculateEncodedLength(char[] input, int length) {
	int count = 0;
	for (int i = 0; i < length; i++) {
		char c = input[i];
		if (c == ' ') {
			count += 3;
		} else {
			count++;
		}
	}
	return count;
}

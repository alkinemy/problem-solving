//문자열 압축

//O(n)
String compress(String word) {
	if (word == null) {
		return null;
	}
	
	if (word.length() == 1) {
		return word;
	}

	int counter = 1;
	StringBuilder stringBuilder = new StringBuilder();
	for (int i = 1; i < word.length(); i++) {
		char previous = word.charAt(i - 1);
		char current = word.charAt(i);
		if (previous == current) {
			counter++;
		} else {
			stringBuilder.append(previous).append(counter);
			counter = 1;
		}
		
		if (i == word.length() - 1) {
			stringBuilder.append(current).append(counter);
		}
	}
	String compressed = stringBuilder.toString();
	if (word.length() < compressed.length()) {
		return word;
	}
	return compressed;

}

//O(n)
String compress2(String word) {
	if (word == null) {
		return null;
	}
	
	if (word.length() == 1) {
		return word;
	}


	char prev = word.charAt(0);
	int lengthGuess = 0;
	for(int i = 1; i < word.length(); i++) {
		char current = word.charAt(i);
		if (prev != current) {
			lengthGuess += 2;
		}
		if (i == word.length() - 1) {
			lengthGuess += 2;
		}
		prev = current;
	}
	
	if (word.length() < lengthGuess) {
		return word;
	}

	int counter = 1;
	StringBuilder stringBuilder = new StringBuilder();
	for (int i = 1; i < word.length(); i++) {
		char previous = word.charAt(i - 1);
		char current = word.charAt(i);
		if (previous == current) {
			counter++;
		} else {
			stringBuilder.append(previous).append(counter);
			counter = 1;
		}
		
		if (i == word.length() - 1) {
			stringBuilder.append(current).append(counter);
		}
	}
	return stringBuilder.toString();

}

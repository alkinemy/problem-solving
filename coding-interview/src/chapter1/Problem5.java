//하나 빼기

/*
 * 1. 길이 체크
 * 2. (길이가 다른 경우에) 짧은 것이 긴 것에 포함되는지 확인
 * 3. (길이가 같은 경우에) 다른 글자가 1개 이하인지 확인
 * O(n)
 */
boolean isEqualWithinOneCharacterChange(String word1, String word2) {
	if (word1 == null || word2 == null) {
		return false;
	}
	if (word1.equals(word2)) {
		return true;
	}
	
	if (word1.length() == word2.length()) {
		return checkIsLessThenOrEqualCharacterDifferent(word1, word2);
	}
	int lengthDifference = word1.length() - word2.length();
	if (lengthDifference == -1 || lengthDifference == 1) {
		return checkLongWordContainsShortWord(word1, word2);
	}
	return false;
}

boolean checkIsLessThenOrEqualCharacterDifferent(String word1, String word2) {
	boolean differentCharacterShown = false;
	for (int i = 0; i < word1.length(); i++) {
		if (word1.charAt(i) != word2.charAt(i)) {
			if (differentCharacterShown) {
				return false;
			}
			differentCharacterShown = true;
		}
	}
	return true;
}

boolean checkLongWordContainsShortWord(String word1, String word2) {
	String longWord;
	String shortWord;
	if (word1.length() > word2.length()) {
		longWord = word1;
		shortWord = word2;
	} else {
		longWord = word2;
		shortWord = word1;
	}

	int longWordPivot = 0;
	int shortWordPivot = 0; 
	boolean differentCharacterShown = false;
	while(shortWordPivot < shortWord.length()) {
		if (longWord.charAt(longWordPivot) == shortWord.charAt(shortWordPivot)) {
			longWordPivot++;
			shortWordPivot++;
			continue;
		}
		if (differentCharacterShown) {
			return false;
		}
		longWordPivot++;
		differentCharacterShown = true;
	}
	return true;
}


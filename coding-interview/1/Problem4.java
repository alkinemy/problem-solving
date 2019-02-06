

//O(n)
boolean isPalindrome(String sentence) {
	Map<Character, Integer> counter = new HashMap<>();
	int length = 0;
	for (char c : sentence.toCharArray()) {
		if (c == ' ') {
			continue;
		}
		char lowerCase = c;
		if (c >= 'A' && c <= 'Z') {
			lowerCase = (char)(c + ('a' - 'A'));
		}

		length++;
		int count = counter.getOrDefault(lowerCase, 0) + 1;
		counter.put(lowerCase, count);
	}
	
	boolean acceptSingleElement = length % 2 == 1;
	boolean singleElementShown = false;
	for (int count : counter.values()) {
		if (count % 2 == 0) {
			continue;
		}
		
		if (acceptSingleElement && !singleElementShown) {
			singleElementShown = true;
			continue;
		}
		return false;
	}
	return true;
}

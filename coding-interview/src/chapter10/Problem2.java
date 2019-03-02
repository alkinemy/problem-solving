



void sort(String[] words) {
	Map<String, List<String>> anagramMap = new HashMap<>();
	
	for (String word : words) {
		String sorted = sort(word);
		List<String> anagrams = anagramMap.getOrDefault(sorted, new ArrayList<>());
		anagrams.add(word);
		anagramMap.put(sorted, anagrams);
	}

	int index = 0;
	for (List<String> anagrams : anagramMap.values()) {
		for (String anagram : anagrams) {
			words[index++] = anagram;
		}
	}
}

String sort(String str) {
	char[] chars = str.toCharArray();
	Arrays.sort(chars);
	return new String(chars);
}

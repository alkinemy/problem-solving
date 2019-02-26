

List<String> getPermutations(String str) {
	if (str.length == 0) {
		List<String> result = new ArrayList<>();
		result.add("");
		return result;
	}
	
	List<String> result = new ArrayList<>();
	for (int i = 0; i < str.length(); i++) {
		String substring = str.substring(0, i) + str.substring(i + 1);
		char ith = str.charAt(i);
		List<String> permutations = getPermutations(substring);
		for (String permutation : permutations) {
			result.add(ith + permutation);
		}
	}
	return result;
}

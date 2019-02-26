

List<String> getPermutations(String str) {
	if (str.length() == 0) {
		List<String> result = new ArrayList<>();
		result.add("");
		return result;
	}

	List<String> result = new ArrayList<>();
	String substring = str.substring(0, str.length() - 1);
	char c = str.charAt(str.length() - 1);
	List<String> permutations = getPermutation(substring);
	for (String permutation : permutations) {
		for (int i = 0; i < permutation.length(); i++) {
			String newPermutation = permutation.substring(0, i) + c + permutation.substring(i); 
			result.add(newPermutation);
		}
	}
	return result;

}




Set<List<Character>> getPermutation(String str) {
	if (str == null || "".equals(str)) {
		return new HashSet<>();
	}
	return getPermutation(str, str.length());
}

Set<List<Character>> getPermutation(String str, int length) {
	if (length == 0) {
		Set<List<Character>> result = new HashSet<>();
		List<Character> permutation = new ArrayList<>();
		result.add(permutation);
		return result;
	}
	Set<List<Character>> permutations = getPermutation(str, length - 1);
	char targetChar = str.charAt(length - 1);
	Set<List<Character>> result = new HashSet<>();
	for (List<Character> permutation : permutations) {
		for (int i = 0; i <= permutation.size(); i++) {
			List<Character> newPermutation = new ArrayList<>();
			newPermutation.addAll(permutation);
			newPermutation.add(i, targetChar);
			result.add(newPermutation);
		}
	}
	return result;
}

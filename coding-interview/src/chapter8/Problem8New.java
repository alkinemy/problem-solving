
List<String> printPerms(String s) {
	List<String> result = new ArrayList<>();
	Map<Character, Integer> map = buildFreqTable(s);
	printPerms(map, "", s.length(), result);
	return result;
}

Map<Character, Integer> buildFreqTable(String s) {
	Map<Character, String> map = new HashMap<>();
	for (char c : s.toCharArray()) {
		map.put(c, map.getOrDefault(c, 0) + 1);
	}
	return map;
}

void printPerms(Map<Character, Integer> map, String prefix, int remaining, List<Stirng> result) {
	if (remaining == 0) {
		result.add(prefix);
		return;
	}

	for (Character c : map.keySet()) {
		int count = map.get(c);
		if (count > 0) {
			map.put(c, count - 1);
			printPerms(map, prefix + c, remaining - 1, result);
			map.put(c, count);
		}
	}
}

//순열 확인: 문자열 두 개가 주어졌을 때 이 둘이 서로 순열 관계에 있는지 확 인하는 메서드를 작성하라.

//O(a + b)
boolean isPermutationOf(String a, String b) {
	if (a == null || b == null) {
		return false;
	}
	if (a.length() != b.length()) {
		return false;
	}

	Map<Character, Integer> counter = new HashMap<>();
	for (char ca : a.toCharArray()) {
		int count = counter.getOrDefault(ca, 0) + 1;
		counter.put(ca, count);
	}
	for (char cb : b.toCharArray()) {
		int count = counter.getOrDefault(cb, 0);
		if (count == 0) {
			return false;
		}
		counter.put(cb, --count);
	}
	return true;
}

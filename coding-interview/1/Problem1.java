// 문자열이 주어졌을 때，이 문자열에 같은 문자가 중복되어
// 등장하는지 확인하는 알고리즘을 작성하라. 자료구조를 추가로 사용하지 않고 풀 수 있는 알고리즘 또한 고민하라.


//제약조건: 알파벳만 있다고 가정
//O(n)
boolean hasDuplicateCharacter(String word) {
	boolean[] check = new boolean[26];
	for (char c : word.toCharArray()) {
		int index = c - 'a';
		if (check[index]) {
			return true;
		}
		check[index] = true;
	}
	return false;
}

//정렬
boolean hasDuplicatedCharacter2(String word) {
	String sorted = sort(word);
	for (int i = 0; i < word.length() - 1; i++) {
		char current = word.charAt(i);
		char next = word.charAt(i + 1);
		if (current == next) {
			return true;
		}
	}
	return false;
}

String sort(String word) {
	//퀵소트
}

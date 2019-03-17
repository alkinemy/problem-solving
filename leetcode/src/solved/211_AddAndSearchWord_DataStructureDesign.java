/**
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */

//bfs
class WordDictionary {

	WordDictionary[] dicts = new WordDictionary[26];
	boolean endOfWord = false;

	/** Initialize your data structure here. */
	public WordDictionary() {
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		if (word == null) {
			return;
		}
		WordDictionary current = this;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int letterIndex = letter - 'a';
			if (current.dicts[letterIndex] == null) {
				current.dicts[letterIndex] = new WordDictionary();
			}
			current = current.dicts[letterIndex];
		}
		current.endOfWord = true;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		if (word == null) {
			return false;
		}

		Queue<WordDictionary> queue = new LinkedList<>();
		queue.add(this);
		for (int i = 0; i < word.length(); i++) {
			Queue<WordDictionary> nextQueue = new LinkedList<>();
			char letter = word.charAt(i);
			while(!queue.isEmpty()) {
				WordDictionary current = queue.remove();
				if (letter == '.') {
					for (WordDictionary dict : current.dicts) {
						if (dict != null) {
							nextQueue.add(dict);
						}
					}
				} else {
					int letterIndex = letter - 'a';
					if (current.dicts[letterIndex] == null) {
						continue;
					}
					nextQueue.add(current.dicts[letterIndex]);
				}
			}
			queue = nextQueue;
		}

		while(!queue.isEmpty()) {
			WordDictionary dict = queue.remove();
			if (dict.endOfWord) {
				return true;
			}
		}
		return false;
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */






//dfs - bfs보다 좀 더 빠르다
//O(min(사전의 크기, 26^k)), k는 word length
class WordDictionary {

	WordDictionary[] dicts = new WordDictionary[26];
	boolean endOfWord = false;

	/** Initialize your data structure here. */
	public WordDictionary() {
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		if (word == null) {
			return;
		}
		WordDictionary current = this;
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			int letterIndex = letter - 'a';
			if (current.dicts[letterIndex] == null) {
				current.dicts[letterIndex] = new WordDictionary();
			}
			current = current.dicts[letterIndex];
		}
		current.endOfWord = true;
	}

	public boolean search(String word) {
		if (word == null) {
			return false;
		}
		return search(word, 0);
	}

	boolean search(String word, int index) {
		if (index == word.length()) {
			return endOfWord;
		}

		char letter = word.charAt(index);
		if (letter == '.') {
			for (WordDictionary dict : dicts) {
				if (dict == null) {
					continue;
				}
				boolean found = dict.search(word, index + 1);
				if (found) {
					return true;
				}
			}
			return false;
		} else {
			int letterIndex = letter - 'a';
			if (dicts[letterIndex] == null) {
				return false;
			}
			return dicts[letterIndex].search(word, index + 1);
		}
	}
}

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */

class Trie {

	private static final int ALPHABET = 26;

	private Trie[] children = new Trie[ALPHABET];

	private boolean endOfWord;

    /** Initialize your data structure here. */
    public Trie() {
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
		Trie current = this;
		for(int i = 0; i < word.length(); i++) {
			int c = word.charAt(i);
			int cIndex = c - 'a';
			if (current.children[cIndex] == null) {
				current.children[cIndex] = new Trie();
			}
			current = current.children[cIndex];
		}
		current.endOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
		if (word == null) {
			return false;
		}

		Trie current = this;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int cIndex = c - 'a';
			if (current.children[cIndex] == null) {
				return false;
			}
			current = current.children[cIndex];
		}

		if (current.endOfWord) {
			return true;
		}
		return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
		if (prefix == null) {
			return false;
		}
		Trie current = this;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			int cIndex = c - 'a';
			if (current.children[cIndex] == null) {
				return false;
			}
			current = current.children[cIndex];
		}
		return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

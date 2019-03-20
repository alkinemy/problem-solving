/**
 * https://leetcode.com/problems/word-search-ii/
 */
class Solution {

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isEndOfWord = false;
		int index = -1;

		public void insert(String word, int index) {
			TrieNode current = this;
			for (int i = 0; i < word.length(); i++) {
				int cIndex = word.charAt(i) - 'a';
				if (current.children[cIndex] == null){
					current.children[cIndex] = new TrieNode();
				}
				current = current.children[cIndex];
			}
			current.isEndOfWord = true;
			current.index = index;
		}

		public void remove(String word) {
			remove(word, 0);
		}

		private boolean remove(String word, int depth) {
			if (word.length() == depth) {
				if (this.isEndOfWord) {
					this.isEndOfWord = false;
				}
				return isEmpty();
			}

			int cIndex = word.charAt(depth) - 'a';
			TrieNode child = this.children[cIndex];
			if (child == null) {
				return false;
			}
			boolean shouldRemoveNode = child.remove(word, depth + 1);
			if (shouldRemoveNode) {
				this.children[cIndex] = null;
			}
			return isEmpty();
		}

		public boolean isEmpty() {
			for (TrieNode child : children) {
				if (child != null) {
					return false;
				}
			}
			return true;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
			return Collections.emptyList();
		}

		TrieNode root = buildTrie(words);
		List<String> result = new ArrayList<>();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				TrieNode next = root.children[board[r][c] - 'a'];
				if (next != null) {
					boolean[][] visited = new boolean[board.length][board[0].length];
					search(board, r, c, root, root, visited, words, result);
				}
			}
		}
		return result;
	}

	TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			root.insert(words[i], i);
		}
		return root;
	}

	void search(char[][] board, int r, int c, TrieNode root, TrieNode node, boolean[][] visited, String[] words, List<String> result) {
		if (node == null) {
			return;
		}
		if (node.isEndOfWord) {
			String word = words[node.index];
			result.add(word);
			root.remove(word);
		}
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
			return;
		}

		int index = board[r][c] - 'a';
		if (node.children[index] != null) {
			visited[r][c] = true;
		}
		int[] rows =    { 0, 0, -1, 1};
		int[] columns = {-1, 1,  0, 0};
		for (int i = 0; i < 4; i++) {
			search(board, r + rows[i], c + columns[i], root, node.children[index], visited, words, result);
		}
	}

}

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
					result.addAll(search(board, r, c, root, words));
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

	List<String> search(char[][] board, int r, int c, TrieNode node, boolean[][] visited, String[] words) {
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
			return Collections.emptyList();
		}

		if (visited[r][c]) {
			return Collections.emptyList();
		}

		visited[r][c] = true;
		List<String> result = new ArrayList<>();
		if (node.isEndOfWord) {
			result.add(words[node.index]);
		} 

		TrieNode next = node.children[board[r][c] - 'a'];
		if (next != null) {
			int[] rows =    { 0, 0, -1, 1};
			int[] columns = {-1, 1,  0, 0};
			for (int i = 0; i < 4; i++) {
				result.addAll(search(board, r + rows[i], c + columns[i], next, visited, words));
			}

		}
		return result;
	}

}

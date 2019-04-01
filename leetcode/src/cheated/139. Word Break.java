/**
 * https://leetcode.com/problems/word-break/
 */

//time limit excedded
class Solution {
	class TrieNode {
		TrieNode[] nodes = new TrieNode[26];
		boolean isEndOfWord;

		public void insert(String word) {
			TrieNode current = this;
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'a';
				if (current.node[index] == null) {
					current.node[index] = new TrieNode();
				}
				current = current.node[index];
			}
			current.isEndOfWord = true;
		}
	}


	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) {
			return true;
		} else if (wordDict == null || wordDict.size() == 0) {
			return false;
		}

		TrieNode root = new TrieNode();
		for (String word : wordDict) {
			root.insert(word);
		}

		return find(root, s);
	}

	boolean find(TrieNode root, String s) {
		TrieNode current = root;
		int i = 0;
		while(i < s.length()) {
			char c = s.charAt(i);
			i++;
			current = current.nodes[c - 'a'];
			if (current == null) {
				return false;
			} else {
				if (current.isEndOfWord && i < s.length()) {
					boolean found = find(root, s.substring(i));
					if (found) {
						return true;
					}
				} else if (current.isEndOfWord && i == s.length()) {
					return true;
				} else if (!current.isEndOfWord && i == s.length()) {
					return false;
				}
			}
		}
		return true;
	}

}


//solution2(memoization)
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		return doWordBreak(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
	}

	public boolean doWordBreak(String s, Set<String> wordDict, int start, Boolean[] memo) {
		if (start == s.length()) {
			return true;
		}
		if (memo[start] != null) {
			return memo[start];
		}
		for (int end = start + 1; end <= s.length(); end++) {
			if (wordDict.contains(s.substring(start, end)) && doWordBreak(s, wordDict, end, memo)) {
				memo[start] = true;
				return true;
			}
		}
		memo[start] = false;
		return false;
	}
}


//solution3(BFS)
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> wordDictSet = new HashSet<>(wordDict);
		boolean[] visited = new boolean[s.length()];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int start = queue.remove();
			if (visited[start]) {
				continue;
			}
			for (int end = start + 1; end <= s.length(); end++) {
				if (wordDictSet.contains(s.substring(start, end))) {
					if (end == s.length()) {
						return true;
					}
					queue.add(end);
				}
			}
			visited[start] = true;
		}
		return false;
	}
}


//solution4(DP)
class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> words = new HashSet<>(wordDict);
		boolean[] memo = new boolean[s.length() + 1];
		memo[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (memo[j] && words.contains(s.substring(j, i))) {
					memo[i] = true;
					break;
				}
			}
		}
		return memo[s.length()];
	}
}

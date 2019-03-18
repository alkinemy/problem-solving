/**
 * https://leetcode.com/problems/palindrome-pairs/
 */

class Solution {

	class TrieNode {
		TrieNode[] children = new TrieNode[26];

		boolean isEndOfWord = false;
		int endWordIndex = -1;
		List<Integer> palindromeIndices = new ArrayList<>();

		void insertReversed(String word, int wordIndex) {
			TrieNode node = this;
			for (int i = word.length() - 1; i >= 0; i--) {
				int index = word.charAt(i) - 'a';
				if (node.children[index] == null) {
					node.children[index] = new TrieNode();
				}
				if (isPalindrome(word, 0, i)) {
					node.palindromeIndices.add(wordIndex);
				}
				node = node.children[index];
			}
			node.isEndOfWord = true;
			node.endWordIndex = wordIndex;
		}

		List<Integer> searchPalindrome(String word) {
			TrieNode node = this;
			List<Integer> found = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'a';
				if (node.children[index] == null) {
					return found;
				}
				node = node.children[index];
				if (node.isEndOfWord && isPalindrome(word, i + 1, word().length - 1)) {
					found.add(node.endWordIndex);
				}
			}
			found.addAll(node.palindromeIndices);
			return found;
		}

		boolean isPalindrome(String word, int start, int end) {
			while(start < end) {
				if (word.charAt(start) != word.charAt(end)) {
					return false;
				}
				start++;
				end--;
			}
			return true;
		}
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		if (words == null || words.length == 0) {
			return Collections.emptyList();
		}

		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			root.insertReversed(words[i], i);
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			List<Integer> indices = root.searchPalindrome(words[i]);
			for (int index : indices) {
				if (index == i) {
					continue;
				}
				List<Integer> pair = new ArrayList<>();
				pair.add(i);
				pair.add(index);
				result.add(pair);
				if ("".equals(words[i])) {
					List<Integer> pair2 = new ArrayList<>();
					pair2.add(index);
					pair2.add(i);
					result.add(pair2);
				}
			}
		}
		return result;
	}
}

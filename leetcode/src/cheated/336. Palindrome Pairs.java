/**
 * https://leetcode.com/problems/palindrome-pairs/
 */

class Solution {

	class TrieNode {
		TrieNode[] children = new TrieNode[26];

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
			node.endWordIndex = wordIndex;
			node.palindromeIndices.add(wordIndex);
		}

		List<Integer> searchPalindrome(String word) {
			TrieNode node = this;
			List<Integer> found = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				if (node.endWordIndex != -1 && isPalindrome(word, i, word.length() - 1)) {
					found.add(node.endWordIndex);
				}

				int index = word.charAt(i) - 'a';
				if (node.children[index] == null) {
					return found;
				}
				node = node.children[index];
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
				result.add(Arrays.asList(i, index));
			}
		}
		return result;
	}
}







//little more optimized?
class Solution {

	class TrieNode {
		TrieNode[] children = new TrieNode[26];

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
			node.endWordIndex = wordIndex;
			node.palindromeIndices.add(wordIndex);
		}

		List<Integer> searchPalindrome(String word, int wordIndex) {
			TrieNode node = this;
			List<Integer> found = new ArrayList<>();
			for (int i = 0; i < word.length(); i++) {
				if (node.endWordIndex != -1 && node.endWordIndex != wordIndex && isPalindrome(word, i, word.length() - 1)) {
					found.add(node.endWordIndex);
				}

				int index = word.charAt(i) - 'a';
				if (node.children[index] == null) {
					return found;
				}
				node = node.children[index];
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
			List<Integer> indices = root.searchPalindrome(words[i], i);
			for (int index : indices) {
				if (index == i) {
					continue;
				}
				result.add(Arrays.asList(i, index));
			}
		}
		return result;
	}
}

package codejam2019.round1.problem3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

	public static class Trie {
		Trie[] children = new Trie[26];

		boolean isEndOfWord;
		int suffixLength;
		Set<String> words = new HashSet<>();

		public void insert(String word) {
			Trie current = this;
			int length = 0;
			for (int i = word.length() - 1; i >= 0 ; i--) {
				current.words.add(word);
				current.suffixLength = length++;
				int index = word.charAt(i) - 'A';
				if (current.children[index] == null) {
					current.children[index] = new Trie();
				}
				current = current.children[index];
			}
			current.words.add(word);
			current.suffixLength = length;
			current.isEndOfWord = true;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int testCount = scanner.nextInt();

		for (int i = 0; i < testCount; i++) {
			int wordCount = scanner.nextInt();
			String[] words = new String[wordCount];
			for (int j = 0; j < wordCount; j++) {
				words[j] = scanner.next();
			}
			int result = solve(words);
			System.out.println("Case #" + (i + 1) + ": " + result);
		}

	}

	private static int solve(String[] words) {
		Trie trie = makeTrie(words);
		List<Trie> availableSuffixes = getAvailableSuffixes(trie);
		if (availableSuffixes.size() == 0) {
			return 0;
		}

		Set<String> used = new HashSet<>();
		for (int i = availableSuffixes.size() - 1; i >= 0; i--) {
			Trie suffix = availableSuffixes.get(i);
			Set<String> suffixWords = suffix.words;
			int count = 0;
			Set<String> selected = new HashSet<>();
			for (String suffixWord : suffixWords) {
				if (used.contains(suffixWord)) {
					continue;
				}
				selected.add(suffixWord);
				count++;
				if (count == 2) {
					break;
				}
			}
			if (count != 2) {
				continue;
			}
			used.addAll(selected);
		}
		return used.size();
	}

	private static List<Trie> getAvailableSuffixes(Trie trie) {
		List<Trie> availableSuffixes = new ArrayList<>();
		Queue<Trie> queue = new LinkedList<>();
		queue.add(trie);
		while(!queue.isEmpty()) {
			Trie current = queue.remove();
			if (current.words.size() < 2) {
				continue;
			}
			if (current.suffixLength != 0) {
				availableSuffixes.add(current);
			}
			for (Trie child : current.children) {
				if (child != null) {
					queue.add(child);
				}
			}
		}
		return availableSuffixes;
	}

	private static Trie makeTrie(String[] words) {
		Trie root = new Trie();
		for (String word : words) {
			root.insert(word);
		}
		return root;
	}

}

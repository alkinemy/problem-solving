/**
 * https://leetcode.com/problems/alien-dictionary/
 */

/**
Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"



You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.
 */
class Solution {

	class Node {
		Set<Node> incoming	= new HashSet<>();
		Set<Node> outgoing = new HashSet<>();
		char value;

		public Node(char value) {
			this.value = value;
		}
	}

    public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		Map<Character, Node> memo = new HashMap<>();
		Node root;
		try {
			root = buildGraph(words, 0, words.length - 1, 0, memo);
		} catch (Exception e) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		traverseGraph(root, sb);
		return sb.toString();
    }

	String traverseGraph(Node root, StringBuilder sb) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			sb.append(current.value);
			boolean found = false;
			for (Node out : current.outgoing) {
				if (out.incoming.size() == 1 && out.incoming.contains(current)) {
					found = true;
					queue.add(out);
					break;
				}	
			}
			for (Node out : current.outgoing) {
				if (!found) {
					queue.add(out);
				}
				out.incoming.remove(current);
			}
		}
		return sb.toString();
	}

	Node buildGraph(String[] words, int from, int to, int index, Map<Character, Node> memo) {
		Node head = null;
		Node previous = null;
		List<Integer> changed = new ArrayList<>();
		Set<Character> shown = new HashSet<>();
		for (int i = from; i <= to; i++) {
			String word = words[index];
			if (i >= word.length()) {
				continue;
			}
			char c = word.charAt(i);
			Node current = memo.getOrDefault(c, new Node(c));
			if (head == null) {
				head = current;
				previous = current;
			} else if (previous == current) {
				continue;
			} else {
				if (shown.contains(c)) {
					throw new RuntimeException("error");
				}
				previous.outgoing.add(current);
				current.incoming.add(previous);
			}
			changed.add(i);
			memo.put(c, current);
			shown.add(c);
			previous = current;
		}

		for(int i = -1; i < changed.size(); i++) {
			int nextFrom = i == -1 ? from : changed.get(i) - 1;
			int nextTo = i + 1 == changed.size() ? to : changed.get(i + 1);
			buildGraph(words, nextFrom, nextTo, index + 1, memo);
		}
		
		return head;
	}
}

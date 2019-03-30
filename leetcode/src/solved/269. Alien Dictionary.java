/**
 * https://leetcode.com/problems/alien-dictionary/
 */
class Solution {

	class Node {
		Set<Node> incoming = new HashSet<>();
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

		Map<Character, Node> nodes = new HashMap<>();
		try {
			buildGraph(words, 0, words.length - 1, 0, nodes);
		} catch (Exception e) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		traverseGraph(nodes, sb);
		return sb.toString();
	}

	String traverseGraph(Map<Character, Node> nodes, StringBuilder sb) {
		Queue<Node> queue = new LinkedList<>();
		for (Node node : nodes.values()) {
			if (node.incoming.size() == 0) {
				queue.add(node);
			}
		}
		Set<Node> shown = new HashSet<>();
		while (!queue.isEmpty()) {
			Node current = queue.remove();
			if (shown.contains(current)) {
				continue;
			}
			shown.add(current);
			sb.append(current.value);
			boolean found = false;
			for (Node out : current.outgoing) {
				if (out.incoming.size() == 1 && out.incoming.contains(current)) {
					found = true;
					queue.add(out);
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

	void buildGraph(String[] words, int from, int to, int index, Map<Character, Node> memo) {
		Node head = null;
		Node previous = null;
		List<Integer> changed = new ArrayList<>();
		Set<Character> shown = new HashSet<>();
		int maxLength = 0;
		for (int i = from; i <= to; i++) {
			String word = words[i];
			maxLength = Math.max(maxLength, word.length());
			if (index >= word.length()) {
				continue;
			}
			char c = word.charAt(index);
			Node current = memo.getOrDefault(c, new Node(c));
			if (head == null) {
				head = current;
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

		if (index >= maxLength) {
			return;
		}

		for (int i = -1; i < changed.size(); i++) {
			int nextFrom = i == -1 ? from : changed.get(i);
			int nextTo = i + 1 == changed.size() ? to : changed.get(i + 1) - 1;
			buildGraph(words, nextFrom, nextTo, index + 1, memo);
		}
	}
}

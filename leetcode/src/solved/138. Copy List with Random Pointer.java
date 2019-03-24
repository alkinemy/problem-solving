/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		
		//original, copied
		Map<Node, Node> nodes = new HashMap<>();
		Node copiedHead = null;
		Node previous = null;
		Node original = head;
		while(original != null) {
			Node copied = nodes.getOrDefault(original, new Node());
			nodes.put(original, copied);
			copied.val = original.val;
			if (original.random != null) {
				Node random = nodes.getOrDefault(original.random, new Node());
				copied.random = random;
				nodes.put(original.random, random);
			}
			if (previous != null) {
				previous.next = copied;
				previous = previous.next;
			} else {
				copiedHead = copied;
				previous = copied;
			}
			original = original.next;
		}
		return copiedHead;
    }
}

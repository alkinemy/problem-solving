

//O(n^2)
Node findCircularStartNode(Node head) {
	if (head == null || head.next == null) {
		return null;
	}
	Node checkNode = head.next;
	int checkNodeIndex = 2;
	Node current = head;
	int index = 1;
	while (checkNode != null) {
		while (index != checkNodeIndex) {
			if (checkNode == current) {
				return current;
			}
			current = current.next;
			index++;
		}
		checkNode = checkNode.next;
		checkNodeIndex++;
		current = head;
		index = 1;
	}
	throw new IllegalStateException("not circular list");
}


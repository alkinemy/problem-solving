
void removeNode(Node node) {
	if (node == null || node.next == null) {
		throw new IllegalStateException("Cannot remove current node");
	}

	Node next = node.next;
	node.data = next.data;
	node.next = next.next;
}

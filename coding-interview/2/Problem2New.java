
Node findKthNode(Node node, int k) {

	Node forwardPointer = node;
	while (--k != 0) {
		forwardPointer = forwardPointer.next;
	}
	Node currentPointer = node;

	while(forwardPointer.next != null) {
		forwardPointer = forwardPointer.next;
		currentPointer = currentPointer.next;
	}
	return currentPointer;
}


//O(n)
Node removeDuplication(Node node) {
	if (node == null) {
		return null;
	}

	boolean[] duplicated = new boolean[128];
	Node previous = null;
	Node current = node;
	while (current != null) {
		int index = (char)current.data - 'a';
		if (duplicated[index]) {
			previous.next = current.next;
			current = previous.next;
		} else {
			duplicated[index] = true;
			previous = current;
			current = current.next;
		}
	}
	return node;
}

Node removeDuplicationNoMoreMemory(Node node) {
	if (node == null) {
		return null;
	}
	
	Node current = node;
	while(current != null) {
		Object data = current.data;
		Node next = removeAll(current.next, data);
		current.next = next;	
		current = current.next;
	}
	return node;
}

Node removeAll(Node node, Object data) {
	Node head = node;
	Node previous = null;
	Node current = node;
	while(current != null) {
		if (current.data == data) {
			if (head == current) {
				head = current.next;
				current = head;
			} else {
				previous.next = current.next;
				current = current.next;
			}
		} else {
			previous = current;
			current = current.next;
		}
	}
	return head;
}

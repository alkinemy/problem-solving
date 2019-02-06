

IntNode divide(IntNode head, int value) {
	IntNode smallerStart = null;
	IntNode smallerEnd = null;

	IntNode biggerOrEqualStart = null;
	IntNode biggerOrEqualEnd = null;

	IntNode current = head;
	while(current != null) {
		IntNode next = current.next;
		current.next = null;
		if (current.data >= value) {
			if (biggerOrEqualStart == null) {
				biggerOrEqualStart = current;
				biggerOrEqualEnd = current;
			} else {
				biggerOrEqualEnd.next = current;
				biggerOrEqualEnd = current;
			}
		} else {
			if (smallerStart == null) {
				smallerStart = current;
				smallerEnd = current;
			} else {
				smallerEnd.next = current;
				smallerEnd = current;
			}
		}
		current = next;
	}
	if (smallerStart == null) {
		return biggerOrEqualStart;
	}
	smallerEnd.next = biggerOrEqualStart;
	return smallerStart;
}

IntNode divide2(IntNode node, int value) {
	IntNode head = node;
	IntNode tail = node;

	IntNode current = node;
	while (current != null) {
		IntNode next = current.next;
		current.next = null;
		if (current.data >= value) {
			tail.next = current;
			tail = current;
		} else {
			current.next = head;
			head = current;
		}
		current = next;
	}
	return head;
}

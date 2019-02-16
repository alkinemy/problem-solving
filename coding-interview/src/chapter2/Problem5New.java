

IntNode nodeSum(IntNode first, IntNode second, int carry) {
	if (first == null && second == null) {
		if (carry == 0) {
			return null;
		} else {
			return new IntNode(carry);
		}
	}

	int sum = carry;
	if (first != null) {
		sum += first.data;
	}
	if (second != null) {
		sum += second.data;
	}
	IntNode node = new IntNode(sum % 10);
	node.next = nodeSum(first != null ? first.next : null,
						second != null ? second.next : null,
						sum / 10);
	return node;
}

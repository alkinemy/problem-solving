
IntNode sum(IntNode first, IntNode second) {
	int firstLength = getLength(first);
	int secondLength = getLength(second);
	if (firstLength > secondLength) {
		int difference = firstLength - secondLength;
		second = addPadding(second, difference);
	} else if (secondLength > firstLength) {
		int difference = secondLength - firstLength;
		first = addPadding(first, difference);
	}
	
	Result result = reversedSum(first, second, 0);
	if (result.carry == 1) {
		IntNode head = new IntNode(1);
		head.next = result.sum;
		return head;
	}
	return result.sum;
}

Result reversedSum(IntNode first, IntNode second, int carry) {
	if (first.next == null && second.next == null) {
		int sum = first.data + second.data + carry;
		return new Result(new IntNode(sum % 10), sum / 10);
	}

	Result result = reversedSum(first.next, second.next, 0);
	int sum = first.data + second.data + result.carry;
	IntNode node = new IntNode(sum % 10);
	node.next = result.sum;
	return new Result(node, sum / 10);
}

int getLength(IntNode node) {
	IntNode current = node;
	int counter = 0;
	while(current != null) {
		counter++;
		current = current.next;
	}
	return counter;
}

IntNode addPadding(IntNode node, int count) {
	IntNode head = node;
	while(count-- != 0) {
		IntNode zero = new IntNode(0);
		zero.next = node;
		head = zero;
	}
	return head;
}

class Result {
	IntNode sum;
	int carry;

	Result(IntNode sum, int carry) {
		this.sum = sum;
		this.carry = carry;
	}
}

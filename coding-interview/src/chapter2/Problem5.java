

IntNode sum(IntNode first, IntNode second) {
	if (first == null) {
		return second;
	}
	if (second == null) {
		return first;
	}

	
	IntNode resultNode;
	int upper = 0;
	int sum = first.data + second.data;
	upper = sum / 10;
	resultNode = new IntNode(sum % 10);
	
	IntNode firstCurrent = first.next;
	IntNode secondCurrent = second.next;
	while (firstCurrent != null && secondCurrent != null) {
		sum = firstCurrent.data + secondCurrent.data + upper;
		resultNode.append(sum % 10);
		upper = sum / 10;

		firstCurrent = firstCurrent.next;
		secondCurrent = secondCurrent.next;
	}

	if (firstCurrent == null && secondCurrent == null) {
		if (upper != 0) {
			resultNode.append(upper);
		}
		return resultNode;
	}
	IntNode rest;
	if (firstCurrent != null) {
		rest = firstCurrent;
	} else {
		rest = secondCurrent;
	}

	while(rest != null) {
		sum = rest.data + upper;
		resultNode.append(sum % 10);
		upper = sum / 10;
		rest = rest.next;
	}
	if (upper != 0) {
		resultNode.append(upper);
	}
	return resultNode;
}

//망함
IntNode sum2(IntNode first, IntNode second) {
	
	IntNode fisrtCurrent = first;
	IntNode secondCurrent = second;

	while(firstCurrent != null && secondCurrent != null) {
		firstCurrent = firstCurrent.next;
		secondCurrent = secondCurrent.next;
	}

	IntNode longNode;
	IntNode shortNode;
	IntNode rest;
	int difference = 0;
	if (firstCurrent != null) {
		longNode = firstNode;
		shortNode = secondNode;
		rest = firstCurrent;
	} else {
		longNode = secondNode;
		shortNode = firstNode;
		rest = secondNode;
	}

	while(rest != null) {
		diffreence++;
		rest = rest.next;
	}

	IntNode longCurrent = longNode;
	while(rest-- <= 0) {
		longCurrent = longCurrent.next;
	}
	IntNode shortCurrent = shortNode;

	int sum = longCurrent.data + shotCurrent.data;
	int firstUpper = sum / 10;
	IntNode result = new IntNode(sum % 10);

	IntNode previous = result;
	longCurrent = longCurrent.next;
	shortCurrent = shortCurrent.next;
	while(shortCurrent != null) {
		sum = longCurrent.data + shortCurrent.data;
		int upper = sum / 10;
		if (upper > 0) {
			previous.data = previous.data + upper;
	}

}

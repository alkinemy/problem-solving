

//O(nm)
Node getIntersection(Node first, Node second) {
	Node firstCurrent = fist;
	Node secondCurrent = second;
	while (firstCurrent != null) {
		while (secondCurrent != null) {
			if (firstCurrent == secondCurrent) {
				return fisrtCurrent;
			}
			secondCurrent = secondCurrent.next;
		}
		firstCurrent = firstCurent.next;
		secondCurrent = second;
	}
	return null;

}

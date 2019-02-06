//1. 리스트를 거꾸로 돌려서 k번째 찾기 -> O(n + k) -> O(n) -> 망한 솔루션
//2. 리스트를 반복해서 돌면서 마커 위치를 하나씩 땡기기 -> O(n^2)


Node findLastKth(Node head, int k) {
	Node reversed = reverse(head);
	Node current = reversed;
	while(--k > 0) {
		if (current == null) {
			return null;
		}
		current = current.next;
	}
	return current;
}

Node reverse(Node node) {
	if (node == null) {
		return null;
	}

	Node previous = null;
	Node current = node;
	while(current != null) {
		Node temp = current.next;
		current.next = previous;
		previous = current;
		current = temp;
	}
	return previous;
}

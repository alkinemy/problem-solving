
Node findStartOfCircular(Node head) {
	Node collision = findCollision(head, head.next.next);
	if (collision == null) {
		return null;
	}

	Node fromHeadNode = head;
	Node fromCollisionNode = collision;
	while (fromHeadNode != fromCollisionNode) {
		fromHeadNode = fromHeadNode.next;
		fromCollisionNde = fromCollisionNode.next;
	}
	return fromHeadNode;
}

Node findCollision(Node slow, Node fast) {
	while (!(fast == null || slow == fast)) {
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}

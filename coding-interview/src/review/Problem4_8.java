Node commonAncestor(Node root, Node p, Node q) {
	if (!covers(root, p) || !covers(root, q)) {
		return null;
	}
	return ancestorHelper(root, p, q);
}

Node ancestorHelper(Node root, Node p, Node q) {
	if (root == null || p == null || q == null) {
		return root;
	}

	boolean pIsOnLeft = covers(root.left, p);
	boolean qIsOnLeft = covers(root.left, q);
	if (pIsOnLeft != qIsOnLeft) {
		return root;
	}
	Node child = pIsOnLeft ? root.left : root.right;
	return ancestorHelper(child, p, q);
}

boolean covers(Node root, Node target) {
	if (root == null) {
		return false;
	}
	if (root == target) {
		return true;
	}
	return covers(root.left, target) || covers(root.right, target);
}


//------------------------------------------------------------------


Node commonAncestor(Node root, Node p, Node q) {
	int diff = getHeight(p) - getHeight(q);
	Node deep = diff > 0 ? p : q;
	Node shallow = diff > 0 ? q : p;

	deep = goUp(deep, Math.abs(diff));
	while (deep != null && shallow != null && deep != shallow) {
		deep = deep.parent;
		shallow = shallow.parent;
	}
	if (deep == null || shallow == null) {
		return null;
	}
	return deep;
}

Node goUp(Node node, int delta) {
	while (node != null && delta > 0) {
		node = node.parent;
		delta--;
	}
	return node;
}

int getHeight(Node node) {
	int height = 0;
	Node current = node;
	while (current != null) {
		current = current.parent;
		height++;
	}
	return height;
}

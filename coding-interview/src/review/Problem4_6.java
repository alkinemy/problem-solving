Node inorderSucc(Node node) {
	if (node == null) {
		return null;
	}

	if (node.right != null) {
		Node leftmost = node.right;
		while (leftmost.left != null) {
			leftmost = leftmost.left;
		}
		return leftmost;
	} else {
		Node current = node;
		Node parent = current.parent;
		while (parent != null && parent.right == current) {
			current = parent;
			parent = parent.parent;
		}
		return parent;
	}
}

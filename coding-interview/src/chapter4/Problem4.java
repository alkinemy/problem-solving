

class Node {
	Node left;
	Node right;
	Object value;
}

//O(logn)
boolean isBalanced(Node node) {
	if (node == null) {
		return false;
	}
	if (node.left == null && node.right == null) {
		return true;
	}

	if (node.left == null) {
		if (hasChildren(node.right)) {
			return false;
		}
		return true;
	}
	if (node.right == null) {
		if (hasChildren(node.left)) {
			return false;
		}
		return true;
	}

	return isBalanced(node.left) && isBalanced(node.right);
}

boolean hasChildren(Node node) {
	return node.left != null || node.right != null;
}

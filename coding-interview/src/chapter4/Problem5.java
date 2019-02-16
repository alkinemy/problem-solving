

class Node {
	Node left;
	Node right;
	int value;

	public Node(int value) {
		this.node = node;
	}
}


boolean isBinarySearchTree(Node node) {
	if (node == null) {
		return true;
	}

	boolean result = true;
	if (node.left != null) {
		if (node.value <= node.left.value) {
			return false;
		}
		result &= isBinarySearchTree(node.left);
	}
	if (node.right != null) {
		if (node.value > node.right.value) {
			return false;
		}
		result &= isBinarySearchTree(node.right);
	}

	return result;
}

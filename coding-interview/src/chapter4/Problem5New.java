

class Node {
	Node left;
	Node right;
	int value;
}

boolean isBinarySearchTree(Node node) {
	return isBinarySearchTree(node, node.value, node.value);
}


boolean isBinarySearchTree(Node node, int min, int max) {
	if (node == null) {
		return true;
	}
	
	boolean result = true;
	if (node.left != null) {
		if (node.left > min) {
			return false;
		}
		result &= isBinarySearchTree(node.left, min, node.left.value);
	}
	if (!result) {
		return false;
	}

	if (node.right != null) {
		if (node.right <= max) {
			return false;
		}
		result &= isBinarySearchTree(node.right, node.right.value, max);
	}
	return result
}

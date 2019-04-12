
boolean isBalanced(Node root) {
	return checkedHeight(root) != Integer.MIN_VALUE;
}

int checkedHeight(Node node) {
	if (node == null) {
		return -1;
	}

	int leftHeight = checkedHeight(node.left);
	if (leftHeight == Integer.MIN_VALUE) {
		return Integer.MIN_VALUE;
	}
	int rightHeight = checkedHeight(node.right);
	if (rightHeight == Integer.MIN_VALUE) {
		return Integer.MIN_VALUE;
	}

	if (Math.abs(leftHeight - rightHeight) > 1) {
		return Integer.MIN_VALUE;
	}
	return Math.max(leftHeight, rightHeight) + 1;
}

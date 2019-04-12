boolean checkBST(Node root) {
	return checkBST(root, null, null);
}

boolean checkBST(Node node, Integer min, Integer max) {
	if (node == null) {
		return true;
	}

	if (min != null && node.value <= min) {
		return false;
	}

	if (max != null && node.value > max) {
		return false;
	}

	if (!checkBST(node.left, min, node.value) || !checkBST(node.right, node.value, max)) {
		return false;
	}
	return true;
}

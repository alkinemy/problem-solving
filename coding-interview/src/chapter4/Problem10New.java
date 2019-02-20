
class Node {
	Node left;
	Node right;
	int value;
}

boolean isSubTree(Node n1, Node n2) {
	if (n1 == null) {
		return false;
	}

	if (n1.value == n2.value && matchTree(n1, n2)) {
		return true;
	}

	return isSubTree(n1.left, n2) || isSubTree(n1.right, n2);
}

boolean matchTree(Node n1, Node n2) {
	if (n1 == null && n2 == null) {
		return true;
	}
	if (n1 == null || n2 == null) {
		return false;
	}
	if (n1.value != n2.value) {
		return false;
	}
	return matchTree(n1.left, n2.left) && matchTree(n1.right, n2.right);
}

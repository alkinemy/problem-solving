class Node {
	Node left;
	Node right;
	int value;
}

int countPath(Node node, int sum, int targetValue) {
	if (node == null) {
		return 0;
	}

	int pathCount = 0;
	if (node.value == sum) {
		pathCount++;
	}

	pathCount += countPath(node.left, sum, targetValue);
	pathCount += countPath(node.left, sum + node.value, targetValue);
	pathCount += countPath(node.right, sum, tagetValue);
	pathCount += countPath(node.right, sum + node.value, targetValue);
	return pathCount;
}

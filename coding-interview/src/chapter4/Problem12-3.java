

int countPath4(Node node, int targetValue) {
	if (node == null) {
		return 0;
	}
	int pathCount = countAllPath(node, targetValue, 0);
	pathCount += countPath(node.left, targetValue);
	pathCount += countPath(node.right, targetValue);
	return pathCount;
}

int countAllPath(Node node, int targetValue, int sum) {
	if (node == null) {
		return 0;
	}

	int count = 0;
	int added = sum + node.value;
	if (added == targetValue) {
		count++;
	}
	count += countAllPath(node.left, targetValue, added);
	count += countAllPath(node.right, targetValue, added);
	return count;
}

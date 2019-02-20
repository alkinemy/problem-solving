static class Node {
	Node left;
	Node right;
	int value;
}

//
int countPath(Node node, int target) {
	if (node == null) {
		return 0;
	}

	int count = 0;
	if (node.value == target) {
		count += 1;	
	}
	count += countPath(node.left, target);
	count += countPath(node.left, target - node.value);
	count += countPath(node.right, target);
	count += countPath(node.right, target - node.value);
	
	return count;

}



class Node {
	Node left;
	Node right;
	Node parent;
	Object value;
}

//O(logn)
Node findInorderSuccessor(Node node) {
	if (node.right != null) { // inorder에 따라서 오른쪽 차일드의 가장 왼쪽 원소 리턴
		return getLeftMost(node.right);
	} else if (node.parent != null) { // inorder에 따라서 방문하지 않은 가장 가까운 가운데 원소 리턴
		return getClosestNotVisitedParent(node);
	} else { //root node
		return null;
	}

}

Node getLeftMost(Node node) {
	Node leftMost = node;
	while (leftMost.left != null) {
		leftMost = leftMost.left;
	}
	return leftMost;
}

Node getClosestNotVisitedParent(Node node) {
	Node current = node;
	Node parent = node.parent;
	while(parent != null && parent.right == current) {
		current = parent;
		parent = parent.parent;
	}
	if (parent == null) {
		return null;
	}
	return parent;
}


class Node {
	Node left;
	Node right;
}

Node findCommonAncestor(Node root, Node p, Node q) {
	if (root == null) {
		return root;
	}

	if (p == root) {
		return p;
	}

	if (q == root) {
		return q;
	}
	
	boolean isPInLeftSide = isExist(root.left, p);
	boolean isQInLeftSide = isExist(root.right, q);
	
	if (isPInLeftSide ^ isQInLeftSide) {
		return root;
	}
	if (isPInLeftSide) {
		return findCommonAncestor(root.left, p, q);
	} else {
		return findCommonAncestor(root.right, p, q);
	}
}

boolean isExist(Node root, Node target) {
	Queue<Node> queue = new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()) {
		Node node = queue.remove();
		if (node == target) {
			return true;
		}
		if (node.left != null) {
			queue.add(node.left);
		}
		if (node.right != null) {
			queue.add(node.right);
		}
	}
	return false;
}

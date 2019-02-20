//has parent node

class Node {
	Node parent;
	Node left;
	Node right;
}

Node findcommonAncestor(Node root, Node p, Node q) {
	if (root == null) {
		return null;
	}
	if (root == p) {
		return p;
	}
	if (root == q) {
		return q;
	}

	int pHeight = getHeight(p);
	int qHeight = getHeight(q);
	Node deeperNode;
	Node shallowNode;
	int difference;
	if (pHeight < qHeight) {
		deeperNode = q;
		shallowNode = p;
		difference = qHeight - pHeight;	
	} else {
		deeperNode = p;
		shallowNode = q;
		difference = pHeight - qHeight;
	}

	while(difference != 0) {
		difference--;
		deeperNode = deeperNode.parent;
	}

	while (deeperNode != shallowNode && deeperNode != null && shallowNode != null) {
		deeperNode = deeperNode.parent;
		shallowNode = shallowNode.parent;
	}
	
	if (deeperNode == null || shallowNode == null) {
		throw new IllegalStateException("Cannot find common ancestor");
	}
	return deeperNode;
}

int getHeight(Node node) {
	int height = 0;
	Node current = node;
	while(current != null) {
		height++;
		current = current.parent;
	}
	return height;
}

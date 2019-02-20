class Node {
	Node left;
	Node right;
	int value;
}


boolean isSubTree(Node n1, Node n2) {
	
	String n1PreOrder = traverseTreeByPreOrder(n1).toString();
	String n2PreOrder = traverseTreeByPreOrder(n2).toString();

	return n1PreOrder.contains(n2PreOrder);
}

StringBuilder traverseTreeByPreOrder(Node node) {
	StringBuilder order = new StringBuilder();
	if (node == null) {
		order.append("X");
		return order;
	}

	order.append(node.value);
	order.append(traverseTreeByPreOrder(node.left));
	order.append(traverseTreeByPreOrder(node.right));
	return order;
}

void inOrder(Node<?> node) {
	if (node == null) {
		return;
	}
	
	inOrder(node.left);
	System.out.print(node.value + " ");
	inOrder(node.right);
}

void preOrder(Node<?> node) {
	if (node == null) {
		return;
	}

	System.out.println(node.value + " ");
	preOrder(node.left);
	preOrder(node.right);
}

void postOrder(Node<?> node) {
	if (node == null) {
		return;
	}

	postOrder(node.left);
	postOrder(node.right);
	System.out.println(node.value + " ");
}

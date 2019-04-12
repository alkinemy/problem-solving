

boolean containsTree(Node t1, Node t2) {
	StringBuidler t1PreOrder = new StringBuilder();
	preOrder(t1, t1PreOrder);

	StrinbBuilder t2PreOrder = new StringBuilder();
	preOrder(t2, t2PreOrder);

	return t1PreOrder.toString().indexOf(t2PreOrder.toString()) != -1;
}

void preOrder(Node node, StringBuilder result) {
	if (node == null) {
		result.append("X ");
		return;
	}
	result.append(node.value).append(" ");
	preOrder(node.left, result);
	preOrder(node.right, result);
}


//----------------

boolean containsTree(Node t1, Node t2) {
	if (t2 == null) { 
		return true;
	}
	return subTree(t1, t2);
}

boolean subTree(Node t1, Node t2) {
	if (t1 == null) {
		return false;
	}
	if (t1.data == t2.data && matchTree(t1, t2)) {
		return true;
	}
	return subTree(t1.left, t2) || subTree(t1.right, t2);
}

boolean matchTree(Node t1, Node t2) {
	if (t1 == null && t2 == null) {
		return true;
	}
	if (t1 == null || t2 == null) {
		return false;
	}
	if (t1.value != t2.value) {
		return false;
	}
	return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
}

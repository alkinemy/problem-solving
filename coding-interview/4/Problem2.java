

class Node {
	Node left;
	Node right;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

Node createBinarySearchTree(int[] array) {
	if (array == null || array.length == 0){
		return null;
	}
	return createBinarySearchTree(array, 0, array.length - 1);
}

Node createBinarySearchTree(int[] array, int start, int end) {
	if (end < start) {
		return null;
	}

	int index = (start + end) / 2;
	Node node = new Node(array[index]);
	
	node.left = createBinarySearchTree(array, 0, index - 1);
	node.right = createBinarySearchTree(array, index + 1, end);
	return node;
}



TreeNode<Integer> createBinarySearchTree(int[] sortedArray) {
	if (sortedArray == null || sortedArray.length == 0) {
		return null;
	}

	return createBinarySearchTree(sortedArray, 0, sortedArray.length - 1);
}


TreeNode<Integer> createBinarySearchTree(int[] sortedArray, int start, int end) {
	if (sortedArray == null || sortedArray.length == 0) {
		throw new IllegalStateException("null/empty array is not allowed");
	}

	if (start == end) {
		return new TreeNode<>(sortedArray[start]);
	}

	int middleIndex = (start + end + 1) / 2;
	TreeNode<Integer> middleNode = new TreeNode<>(sortedArray[middleIndex]);
	middleNode.left = createBinarySearchTree(sortedArray, start, middleIndex - 1);
	middleNode.right = createBinarySearchTree(sortedArray, middleIndex + 1, end);
	return middleNode;
}

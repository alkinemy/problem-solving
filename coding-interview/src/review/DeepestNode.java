

List<Node> findDeepestNode(Node root) {
	if (root == null) {
		return null;
	}

	List<Node> result = new ArrayList<>();
	List<Integer> maxLevel = new ArrayList<>();
	maxLevel.add(0);
	getDeepestNode(root, 0, maxLevel, result);
	return result;
}

void getDeepestNode(Node node, int level, List<Integer> maxLevel, List<Node> result) {
	if (node == null) {
		return;
	}
	
	int nextLevel = level + 1;
	if (level == maxLevel) {
		result.add(node);
	} else if (level > maxLevel.get(0)) {
		result.clear();
		result.add(node);
		maxLevel.clear()
		maxLevel.add(nextLevel);
	}		
	getDeepestNode(node.left, nextLevel, maxLevel, result);
	getDeepestNode(node.right, nextLevel, maxLevel, result);
}

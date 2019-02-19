
class Node {
	Node left;
	Node right;
	int value;
}

List<List<Node>> findBuildOrders(Node root) {
	if (root == null) {
		List<List<Node>> result = new ArrayList<>();
		List<Node> emptyList = new ArrayList<>();
		result.add(emptyList);
		return result;
	}

	List<List<Node>> leftOrders = findBuildOrders(root.left);
	List<List<Node>> rightOrders = findBuildOrders(root.right);

	List<List<Node>> results = new ArrayList<>();
	List<Node> prefix = new ArrayList<>();
	prefix.add(root);
	for (List<Node> leftOrder : leftOrders) {
		for (List<Node> rightOrder : rightOrders) {
			List<List<Node>> result = getCombinations(leftOrder, rightOrder, prefix);
			results.addAll(result);
		}
	}
	return results;
}

List<List<Node>> getCombinations(List<Node> leftOrder, List<Node> rightOrder, List<Node> prefix) {
	if (leftOrder.isEmpty() && rightOrder.isEmpty()) {
		List<Node> prefixCopy = new ArrayList<>(prefix);
		List<List<Node>> result = new ArrayList<>();
		result.add(prefixCopy);
		return result;
	}

	if (leftOrder.isEmpty()) {
		List<List<Node>> result = new ArrayList<>();
		List<Node> prefixCopy = new ArrayList<>(prefix);
		prefixCopy.addAll(rightOrder);
		result.add(prefixCopy);
		return result;
	}

	if (rightOrder.isEmpty()) {
		List<List<Node>> result = new ArrayList<>();
		List<Node> prefixCopy = new ArrayList<>(prefix);
		prefixCopy.addAll(leftOrder);
		result.add(prefixCopy);
		return result;
	}

	List<Node> leftOrderPrefix = new ArrayList<>(prefix);
	List<Node> firstRemovedLeftOrder = new ArrayList<>(leftOrder);
	leftOrderPrefix.add(firstRemovedLeftOrder.remove(0));
	List<List<Node>> leftStartCombinations = getCombinations(firstRemovedLeftOrder, rightOrder, leftOrderPrefix);

	List<Node> rightOrderPrefix = new ArrayList<>(prefix);
	List<Node> firstRemovedRightOrder = new ArrayList<>(rightOrder);
	rightOrderPrefix.add(firstRemovedRightOrder.remove(0));
	List<List<Node>> rightStartCombinations = getCombinations(leftOrder, firstRemovedRightOrder, rightOrderPrefix);

	List<List<Node>> result = new ArrayList<>();
	result.addAll(leftStartCombinations);
	result.addAll(rightStartCombinations);
	return result;
}

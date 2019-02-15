
static class Node {
	Node left;
	Node right;
	int value;

	public Node(int value) {
		this.value = value;
	}
}

List<List<Integer>> findAllAvailableOrders(Node root) {
	List<List<Integer>> result = new ArrayList<>();

	List<Node> nodes = new ArrayList<>();
	nodes.add(root);
	while(!nodes.isEmpty()) {
		List<List<Integer>> permutations = getAvailablePermutationsOf(nodes);
		result = cartesianProduct(result, permutations);
		List<Node> nextVisit = new ArrayList<>();
		for (Node node : nodes) {
			if (node.left != null) {
				nextVisit.add(node.left);
			}
			if (node.right != null) {
				nextVisit.add(node.right);
			}
		}
		nodes = nextVisit;
	}

	return result;
}

List<List<Integer>> getAvailablePermutationsOf(List<Node> nodes) {
	if (nodes.isEmpty()) {
		return new ArrayList<>();
	}
	if (nodes.size() == 1) {
		List<Integer> result = new ArrayList<>();
		result.add(nodes.get(0).value);
		return Collections.singletonList(result);
	}
	Node node = nodes.get(0);
	List<List<Integer>> permutations = getAvailablePermutationsOf(nodes.subList(1, nodes.size()));
	List<List<Integer>> results = new ArrayList<>();
	for (List<Integer> permutation : permutations) {
		for (int i = 0; i <= permutation.size(); i++) {
			List<Integer> result = new ArrayList<>(permutation);
			result.add(i, node.value);
			results.add(result);
		}
	}
	return results;
}

List<List<Integer>> cartesianProduct(List<List<Integer>> heads, List<List<Integer>> tails) {
	List<List<Integer>> results = new ArrayList<>();
	if (heads.isEmpty()) {
		for (List<Integer> tail : tails) {
			List<Integer> product = new ArrayList<>(tail);
			results.add(product);
		}
		return results;
	}
	for (List<Integer> head : heads) {
		for (List<Integer> tail : tails) {
			List<Integer> product = new ArrayList<>();
			product.addAll(head);
			product.addAll(tail);
			results.add(product);
		}
	}
	return results;
}

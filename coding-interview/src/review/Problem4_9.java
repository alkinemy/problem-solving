List<List<Integer>> allSequences(Node root) {
	List<List<Integer>> result = new ArrayList<>();
	if (root == null) {
		result.add(new LinkedList<>());
		return result;
	}

	List<Integer> prefix = new LinkedList<>();
	prefix.add(root.value);

	List<List<Integer>> leftSequences = allSequences(root.left);
	List<List<Integer>> rightSequences = allSequences(root.right);

	for (List<Integer> left : leftSequences) {
		for (List<Integer> right : rightSequences) {
			List<List<Integer>> merged = new ArrayList<>();
			merge(left, right, merged, prefix);
			result.addAll(merged);
		}
	}
	return result;
}

void merge(List<Integer> left, List<Integer> right, List<List<Integer>> results, List<Integer> prefix) {
	if (left.size() == 0 || right.size() == 0) {
		List<Integer> result = new LinkedList<>(prefix);
		result.addAll(left);
		result.addAll(right);
		results.add(result);
		return;
	}

	int leftHead = left.remove(0);
	prefix.add(prefix.size() - 1, leftHead);
	merge(left, right, results, prefix);
	prefix.remove(prefix.size() - 1);
	left.add(0, leftHead);

	int rightHead = right.remove(0);
	prefix.add(prefix.size() - 1, rightHead);
	merge(left, right, results, prefix);
	prefix.remove(prefix.size() - 1);
	right.add(0, rightHead);
}

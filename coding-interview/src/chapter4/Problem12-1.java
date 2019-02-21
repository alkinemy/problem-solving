
class Node {
	Node left;
	Node right;
	int value;
}

int countPath(Node node, int targetValue) {
	return countPath(node, 0, targetValue, new HashMap<>());
}

int countPath(Node node, int runningSum, int targetValue, Map<Integer, Integer> sums) {
	if (node == null) {
		return 0;
	}

	int sum = runningSum + node.value;
	int sumPathCount = sums.getOrDefault(sum, 0);
	sums.put(sum, sumPathCount + 1);

	int difference = sum - targetValue;
	int pathCount = sums.getOrDefault(difference, 0);

	if (difference == 0) {
		pathCount++;
	}
	
	pathCount += countPath(node.left, sum, targetValue, sums);
	pathCount += countPath(node.right, sum, targetValue, sums);
	
	sums.put(sum, sumPathCount);

	return pathCount;
}

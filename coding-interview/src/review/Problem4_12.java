//brute force

int countPathsWithSum(Node root, int target) {
	if (root == null) {
		return 0;
	}
	
	int fromRoot = countPathsWithSumFromNode(root, target, 0);

	int fromLeft = countPathsWithSum(root.left, target);
	int fromRight = countPathsWithSum(root.right, target);
	return fromRoot + fromLeft + fromRight;
}

int countPathsWithSumFromNode(Node node, int target, int currentSum) {
	if (node == null) {
		return 0;
	}

	currentSum += node.value;
	int paths = 0;
	if (currentSum == target) {
		paths++;
	}

	paths += countPathsWithSumFromNode(node.left, target, currentSum);
	paths += countPathsWithSumFromNode(node.right, target, currentSum);
	return paths;
}

//-----------------------------

int countPathsWithSum(Node root, int target) {
	return countPathsWithSum(root, target, 0, new HashMap<>());
}

int countPathsWithSum(Node node, int target, int runningSum, Map<Integer, Integer> pathCounts) {
	if (node == null) {
		return 0;
	}

	runningSum += node.value;
	int sum = runningSum - target;
	int paths = pathCounts.getOrDefault(sum, 0);
	if (runningSum == target) {
		paths++;
	}

	increment(pathCounts, runningSum, 1);
	paths += countPathsWithSum(node.left, target, runningSum, pathCounts);
	paths += countPathsWithSum(node.right, target, runningSum, pathCounts);
	increment(pathCounts, runningSum, -1);
	return paths;
}

void increment(Map<Integer, Integer> pathCounts, int sum, int delta) {
	int counts = pathCounts.getOrDefault(sum, 0) + delta;
	if (counts == 0) {
		pathCounts.remove(sum);
	} else {
		pathCounts.put(sum, counts);
	}
}

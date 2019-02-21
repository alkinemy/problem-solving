class Node {
	Node left;
	Node right;
	int value;
	int size;

	public Node(int value) {
		this.value = value;
		this.size = 1;
	}

	public void insert(int insertValue) {
		if (insertValue < value) {
			if (left != null) {
				left.insert(insertValue);
			} else {
				left = new Node(insertValue);
			}
		} else {
			if (right != null) {
				right.insert(insertValue);
			} else {
				right = new Node(insertValue);
			}
		}
		size++;
	}

	public Node getRandomNode() {
		Random random = new Random();
		int pivot = random.nextInt(size);
		return getRandomNode(pivot);
	}

	private Node getRandomNode(int pivot) {
		int leftSize = left == null ? 0 : left.size;
		if (pivot == leftSize) {
			return this;
		}
		if (pivot < leftSize) {
			return left.getRandomNode(pivot);
		}
		return right.getRandomNode(pivot - (leftSize + 1));
	}
}

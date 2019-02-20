class Node {

	Node left;
	Node right;
	int value;
	private int size;

	public Node(int value) {
		this.value = value;
		this.size = 1;
	}

	Node getRandomNode() {
		Random random = new Random();	
		int pivot = random.nextInt(size) + 1;
		int leftSize = left == null ? 0 : left.size;
		int rightSize = right == null ? 0 : right.size;
		if (pivot <= leftSize) {
			return left.getRandomNode();
		} else if (pivot > size - rightSize) {
			return right.getRandomNode();
		} else {
			return this;
		}
	}

	void insert(int newValue) {
		if (newValue < value) {
			if (left != null) {
				left.insert(newValue);
			} else {
				left = new Node(newValue);
			}
		} else {
			if (right != null) {
				right.insert(newValue);
			} else {
				right = new Node(newValue);
			}
		}
		size++;
	}
}

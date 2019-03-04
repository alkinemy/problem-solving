class Node {

	int leftSize = 0;
	Node left;
	Node right;
	int value;


	void track(int x) {
		if (x <= value) {
			if (left == null) {
				left = new Node(x);
			} else {
				left.track(x);
			}
			leftSize++;
		} else {
			if (right == null) {
				right = new Node(x);
			} else {
				right.track(x);
			}
		}
	}

	int getRankOfNumber(int x) {
		if (x == value) {
			return leftSize;
		}
		if (x < value) {
			if (left == null) {
				return -1;
			}
			return left.getRankOfNumber(x);
		}
		
		if (right == null) {
			return -1;
		}
		int rank = right.getRankOfNumber(x);
		if (rank == -1) {
			return -1;
		}
		return leftSize + 1 + rank;
	}

}

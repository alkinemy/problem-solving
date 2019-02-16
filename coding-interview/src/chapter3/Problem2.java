

class MinStack extends Stack<Integer> {
	private Stack<Integer> minValues = new Stack<>();

	public void push(Integer value) {
		super.push(value);
		if (minValues.isEmpty()) {
			minValues.push(value);
		} else {
			if (minValues.peek() < value) {
				minValues.push(minValues.peek());
			} else {
				minValues.push(value);
			}
		}
	}

	public Integer pop() {
		minValues.pop();
		return super.pop();
	}

	public Integer min() {
		return minValues.peek();
	}
}

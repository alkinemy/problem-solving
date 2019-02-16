

class SetOfStacks {

	private final Stack<Stack<Object>> stackContainer = new Stack<>();
	private Stack<Object> stack;

	private final int capacity;
	private int index;

	public SetOfStacks(int capacity) {
		this.stack = new Stack<>();
		this.capacity = capacity;
		this.index = 1;
	}

	public void push(Integer value) {
		if (stack.size() > capacity) {
			stackContainer.push(stack);
			stack = new Stack<>();
			index++;
		}
		stack.push(value);
	}

	public Object pop() {
		if (stack.isEmpty()) {
			if (stackContainer.isEmpty()) {
				throw new EmptyStackException();
			}
			this.stack = stackContainer.pop();
			index--;
		}
		return this.stack.pop();
	}

	public Object popAt(int index) {
		if (this.index < index) {
			throw new IllegalArgumentException("invalid index");
		} else if (this.index == index) {
			if (stack.isEmpty()) {
				throw new EmptyStackException();
			}
			return stack.pop();
		} else {
			Stack<Stack<Object>> temp = new Stack<>();
			int containerIndex = this.index;
			while(--containerIndex != index) {
				temp.push(stackContainer.pop());
			}
			Stack<Object> indexStack = stackContainer.pop();
			Object returnValue = indexStack.pop();
			stackContainer.push(indexStack);
			while(!temp.isEmpty()) {
				stackContainer.push(temp.pop());
			}
			return returnValue;
		}
	}

	public boolean isEmpty() {
		return stack.isEmpty() && stackContainer.isEmpty();
	}

}

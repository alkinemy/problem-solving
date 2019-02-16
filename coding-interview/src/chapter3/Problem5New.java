

void sort(Stack<Integer> stack) {
	Stack<Integer> temp = new Stack<>();

	while(!stack.isEmpty()) {
		if (temp.isEmpty()) {
			temp.push(stack.pop());
			continue;
		}
		
		int target = stack.pop();
		while(!temp.isEmpty() && temp.peek() > target) {
			stack.push(temp.pop());
		}
		temp.push(target);
	}

	while(!temp.isEmpty()) {
		stack.push(temp.pop());
	}
}

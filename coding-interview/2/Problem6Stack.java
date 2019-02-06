

boolean isPalindrome(Node node) {
	Node fastRunner = node.next;
	Node slowRunner = node;
	
	while (!(fastRunner == null || fastRunner.next == null)) {
		fastRunner = fastRunner.next.next;
		slowRunner = slowRunner.next;
	}
	
	Stack<Object> stack = new Stack<>();
	Node stackNode = slowRunner.next;
	while(stackNode != null) {
		stack.push(stackNode.data);
		stackNode = stackNode.next;
	}

	Node current = node;
	while(!stack.isEmpty()) {
		if (current == null) {
			return false;
		}
		Object value = stack.pop();
		if (current.data != value) {
			return false;
		}
		current = current.next;
	}
	return true;
}

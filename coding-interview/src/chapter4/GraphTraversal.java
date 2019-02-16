
void dfs(GraphNode<?> node) {
	if (node == null) {
		return;
	}
	if (!node.isVisited) {
		System.out.print(node.value + " ");
		node.isVisited = true;
	}
	for (GraphNode<?> child : node.children) {
		dfs(child);
	}
}

void stackDfs(GraphNode<?> root) {
	Stack<GraphNode<?>> stack = new Stack<>();
	stack.push(root);

	while(!stack.isEmpty()) {
		GraphNode<?> current = stack.pop();
		System.out.print(current.value + " ");
		current.isVisited = true;
		for (GraphNode<?> child : current.children) {
			if (!child.isVisited) {
				stack.push(child);
			}
		}
	}
}

void bfs(GraphNode<?> node) {
	Queue<GraphNode<?>> queue = new LinkedList<>();
	queue.add(node);

	while(!queue.isEmpty()) {
		GraphNode<?> current = queue.remove();
		System.out.print(current.value + " ");
		current.isVisit = true;
		for (GraphNode<?> child : current.children) {
			if (!child.isVisit) {
				queue.add(child);
			}
		}
	}
}

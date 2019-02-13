
class Node {
	Node left;
	Node right;
	Object data;

	public Node(Object data) {
		this.data = data;
	}

}

//O(n)
List<List<Node>> connectSameDepthNodes(Node root) {
	if (node == null) {
		return null;
	}
	Queue<Node> queue1 = new LinkedList<>();
	Queue<Node> queue2 = new LinkedList<>();

	Queue<Node> runningQueue = queue1;
	Queue<Node> waitingQueue = queue2;
	runningQueue.add(root);

	List<List<Node>> nodeLists = new LinkedList<>();
	while(!(runningQueue.isEmpty() && waitingQueue.isEmpty())) {
		List<Node> nodes = new LinkedList<>();
		while(!runningQueue.isEmpty()) {
			Node node = runningQueue.remove();
			nodes.add(node);
			if (node.left != null) {
				waitingQueue.add(node.left);
			}
			if (node.right != null) {
				waitingQueue.add(node.right);
			}
		}
		nodeLists.add(nodes);
		Queue<Node> temp = runningQueue;
		runningQueue = waitingQueue;
		waitingQueue = temp;
	}

	return nodeLists;
	
}


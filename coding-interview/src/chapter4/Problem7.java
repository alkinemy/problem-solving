class ProjectNode {
	Set<Node> incoming = new HashSet<>();
	Set<Node> outgoing = new HashSet<>();
	String value;

	public ProjectNode(String value) {
		this.value = value;
	}	
}

class ProjectEdge {
	String from;
	String to;

	public ProjectEdge(String from, String to) {
		this.from = from;
		this.to = to;
	}
}
gjList<String> findProcessingOrder(List<String> values, List<ProjectEdge> edges) {
	List<ProjectNode> nodes = buildGraph(values, edges);
	return findProcessingOrder(nodes);
}


List<ProjectNode> buildGraph(List<String> values, List<ProjectEdge> edges) {
	Map<String, ProjectNode> nodeMap = new HashMap<>();
	for (String value : values) {
		nodeMap.put(value, new ProjectNode(value));
	}
	for (ProjectEdge edge : edges) {
		ProjectNode from = nodeMap.get(edge.from);
		ProjectNode to = nodeMap.get(edge.to);
		from.outgoing.add(to);
		to.incoming.add(from);
	}
	return new ArrayList<>(nodeMap.values());
}

//queue version
List<String> findProcessingOrder(List<ProjectNode> nodes) {
	List<ProjectNode> startNodes = findStartNode(nodes);
	if (startNodes == null || startNodes.isEmpty()) {
		throw new IllegalStateException("Cannot find order");
	}
	
	Queue<ProjectNode> searchNodes = new LinkedList<>(startNodes);
	List<String> result = new ArrayList<>();
	while (!searchNodes.isEmpty()) {
		ProjectNode node = searchNodes.remove();
		result.add(node.value);
		for (ProjectNode outgoing : node.outgoing) {
			outgoing.incoming.remove(node);
			if (outgoing.incoming.isEmpty()) {
				searchNodes.add(outgoing);
			}
		}
	}
	return result;
}

List<String> findProcessingOrder(List<ProjectNode> nodes) {
	List<ProjectNode> searchNodes = findStartNode(nodes);
	if (searchNodes == null || searchNodes.isEmpty()) {
		throw new IllegalStateException("Cannot find order");
	}
	
	List<String> result = new ArrayList<>();
	while(!searchNodes.isEmpty()) {
		Liar<ProjectNode> nextNodes = new ArrayList<>();
		for (ProjectNode node : searchNodes) {
			result.add(node.value);	
			for (ProjectNode outgoing : node.outgoing) {
				outgoing.incoming.remove(node);
				if (outgoing.incoming.isEmpty()) {
					nextNodes.add(outgoing);
				}
			}
		}
		searchNodes = nextNodes;
	}
	return result;
}


List<ProjectNode> findStartNode(List<ProjectNode> nodes) {
	List<ProjectNode> startNodes = new ArrayList<>();
	for (ProjectNode node : nodes) {
		if (node.incoming.isEmpty()) {
			startNodes.add(node);
		}
	}
	return startNodes;
}

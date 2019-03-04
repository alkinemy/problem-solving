class Edge {
	Vertex from;
	Vertex to;
	int weight;
}

class Vertex {
	int value;
	List<Edge> edges;
}

class Graph {
	List<Vertex> vertices;
	List<Edge> edges;
}

int shortestPath(Graph graph, Vertex start) {
	int[] weights = new int[graph.vertices.size()];
	for (int i = 0; i < weights.length; i++) {
		weights[i] = Integer.MAX_VALUE;
	}
	weights[start.value] = 0;
	Vertex current = start;
	while(current != null) {
		Vertex nextVertex = null;
		for (int i = 0; i < current.edges.size(); i++) {
			Edge edge = current.edges.get(i);
			int newWeight = weights[edge.from.value] + edge.weight;
			if (weights[edge.to.value] > newWeight) {
				weights[edge.to.value] = newWeight;
				if (nextVertex == null || weights[nextVertex.value] > weights[edge.to.value]) {
					nextVertex = edge.to;
				}
			}
		}
		current = nextVertex;
	}
	int result = 0;
	for (int i = 0; i < weights.length; i++) {
		result += weights[i];
	}
	return result;
}

/**
 * https://leetcode.com/problems/lru-cache/
 */

class LRUCache {

	private Map<Integer, Integer> data = new HashMap<>();

	private final int capacity;

	private Map<Integer, Node> recentMap = new HashMap<>();
	private Node recentTail;
	private Node recentHead;

    public LRUCache(int capacity) {
    	this.capacity = capacity; 
		this.recentHead = null;
		this.recentTail = null;
    }
    
    public int get(int key) {
		int value = data.getOrDefault(key, -1);
		if (value != -1) {
			Node removed = removeNode(key);
			appendNode(removed);
		}
		return value;
    }
    
    public void put(int key, int value) {
		data.put(key, value);
		if (recentMap.containsKey(key)) {
			Node removed = removeNode(key);
			appendNode(removed);
		} else {
			Node current = new Node(key);
			appendNode(current);
		}

		if (recentMap.size() > capacity) {
			Node removed = removeNode(recentHead.key);
			data.remove(removed.key);
		}
		
    }

	private void appendNode(Node node) {
		if (recentTail == null && recentHead == null) {
			recentHead = node;
			recentTail = node;
		} else {
			recentTail.next = node;
			node.previous = recentTail;
			recentTail = node;
		}
		recentMap.put(node.key, node);
	}

	private Node removeNode(int key) {
		Node node = recentMap.get(key);
		Node previous = node.previous;
		Node next = node.next;
		if (previous == null && next == null) {
			recentHead = null;
			recentTail = null;
		} else if (previous == null) { //node -> head
			recentHead = next;
			next.previous = null;
		} else if (next == null) { //node -> tail
			previous.next = null;
			recentTail = previous;
		} else {
			previous.next = next;
			next.previous = previous;
		}
		node.previous = null;
		node.next = null;
		recentMap.remove(key);
		return node;
	}

	class Node {
		Node previous;
		Node next;
		int key;

		public Node(int key) {
			this.key = key;
		}
	}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

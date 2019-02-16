
class MyQueue<T> {

	private Stack<T> data = new Stack<>();
	private Stack<T> temp = new Stack<>();

	public void enqueue(T t) {
		if (!temp.isEmpty()) {
			if (!dataQueue.isEmpty()) {
				throw new IllegalStateException("not empty data queue and temp state is not allowed");
			}
			while(!temp.isEmpty()) {
				data.push(temp.pop());
			}
		}
		data.push(t);
	}

	public T dequeue() {
		if (temp.isEmpty() && data.isEmpty()) {
			throw new EmptyQueueException();
		}
		if (!temp.isEmpty()) {
			if (!data.isEmpty()) {
				throw new IllegalStateException("not empty data queue and temp state is not allowed");
			}
			return temp.pop();
		}
		while(!data.isEmpty()) {
			temp.push(data.pop());
		}
		return temp.pop();
	}

}

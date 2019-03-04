
class Ranking1 {
	Map<Integer, Integer> counter = new HashMap<>();

	void track(int x) { //O(1)
		int count = counter.getOrDefault(x, 0) + 1;
		counter.put(x, count);
	}

	int getRankOfNumber(int x) { //O(n)
		int count = 0;
		for (int key : counter.keySet()) {
			if (key < x) {
				count += counter.get(key);
			}
		}
		return count;
	}

}

class Ranking2 {
	List<Integer> list = new LinkedList<>();

	void track(int x) { //O(n);
		if (list.isEmpty()) {
			list.add(x);
			return;
		}

		int i = 0; 
		while (i < list.size() && list.get(i) < x) { //can change into binary search
			i++;
		}
		list.add(i, x);
	}

	int getRankOfNumber(int x) { //O(n)
		int count = 0;
		int index = 0;
		while(index < list.size() && list.get(index) < x) {
			count++;
			index++;
		}
		return count;
	}

}

class Counter {
	int number;
	int accumulateCount;
}

class Ranking3 {
	List<Counter> counterList = new LinkedList<>();
	Map<Integer, Counter> counterMap = new HashMap<>();

	void track(int x) { //O(n)
		int i = 0;
		while (i < counterList.size()) {
			Counter c = counterList.get(i);
			if (c.number == x) {
				return;
			}
			if (c.number > x) {
				break;
			}
			i++;
			c.accumulateCount++;
		}
		Counter counter = new Counter(x, 0);
		counterList.add(counter);
		counterMap.put(x, counter);
		return;
	}


	int getRankOfNumber(int x) { //O(1)
		Counter counter = counterMap.get(x);
		if (counter == null) {
			return 0;
		}
		return counter.accumulateCount;
	}
}

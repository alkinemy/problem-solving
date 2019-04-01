/**
 * https://leetcode.com/problems/merge-intervals/
 */

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty()) {
			return intervals;
		}

		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			nodes.add(new Node(interval.start, i, true));
			nodes.add(new Node(interval.end, i, false));
		}

		nodes.sort((v1, v2) -> {
            int compare = Integer.compare(v1.value, v2.value);
            if (compare == 0) {
                if ((v1.isStart && v2.isStart) || (!v1.isStart && !v2.isStart)) {
                    return Integer.compare(v1.index, v2.index);
                } else if (v1.isStart) {
                    return -1;
                } else {
                    return 1;
                }
            }
            return compare;  
        });

		List<Interval> result = new ArrayList<>();
		int startPoint = 0;
		int startCount = 0;
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			if (node.isStart) {
				if (startCount == 0) {
					startPoint = i;
				}
				startCount++;
				continue;
			}

			startCount--;
			if (startCount == 0) {
				result.add(new Interval(nodes.get(startPoint).value, nodes.get(i).value));
			}
		}
		return result;
	}

	class Node {
		int value;
		int index;
		boolean isStart;

		public Node(int value, int index, boolean isStart) {
			this.value = value;
			this.index = index;
			this.isStart = isStart;
		}
	}
}




//connected graph(solution), O(n^2) -> time limit exceeded
class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty()) {
			return intervals;
		}

		Map<Interval, List<Interval>> overlapped = new HashMap<>();
		for (Interval interval1 : intervals) {
			for (Interval interval2 : intervals) {
				if (isOverwrapped(interval1, interval2)) {
					List<Interval> overlapped1 = overlapped.getOrDefault(interval1, new ArrayList<>());
					overlapped1.add(interval2);
					overlapped.put(interval1, overlapped1);

					List<Interval> overlapped2 = overlapped.getOrDefault(interval2, new ArrayList<>());
					overlapped2.add(interval1);
					overlapped.put(interval2, overlapped2);
				}
			}
		}

		Map<Integer, List<Interval>> collected = new HashMap<>();
		Stack<Interval> stack = new Stack<>();
		Set<Interval> visited = new HashSet<>();
		int round = 0;
		for (Interval interval : intervals) {
			stack.push(interval);
			while(!stack.isEmpty()) {
				Interval current = stack.pop();
				if (!visited.contains(current)) {
					visited.add(current);
					List<Interval> collectedIntervals = collected.getOrDefault(round, new ArrayList<>());
					collectedIntervals.add(current);
					collected.put(round, collectedIntervals);
					if (overlapped.containsKey(current)) {
						for (Interval next : overlapped.get(current)) {
							stack.push(next);
						}
					}
				}
			}
			round++;
		}

		List<Interval> result = new ArrayList<>();
		for(List<Interval> interval : collected.values()) {
			result.add(mergeIntervals(interval));	
		}

		return result;
	}

	private Interval mergeIntervals(List<Interval> intervals) {
		int minStart = Integer.MAX_VALUE;
		int maxEnd = Integer.MIN_VALUE;

		for (Interval interval : intervals) {
			minStart = Math.min(minStart, interval.start);
			maxEnd = Math.max(maxEnd, interval.end);
		}

		return new Interval(minStart, maxEnd);
	}

	private boolean isOverwrapped(Interval interval1, Interval interval2) {
		return interval1.start <= interval2.end && interval2.start <= interval1.end;
	}
}




//sort(solution) -> O(nlogn)
class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty()) {
			return intervals;
		}

		intervals.sort((v1, v2) -> Integer.compare(v1.start, v2.start));
		List<Interval> result = new ArrayList<>();
		int minStart = intervals.get(0).start;
		int maxEnd = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);
			if (current.start <= maxEnd) { //overlapped
				maxEnd = Math.max(maxEnd, current.end);
			} else {
				result.add(new Interval(minStart, maxEnd));
				minStart = current.start;
				maxEnd = current.end;
			}
		}
		result.add(new Interval(minStart, maxEnd));
		return result;
	}
}

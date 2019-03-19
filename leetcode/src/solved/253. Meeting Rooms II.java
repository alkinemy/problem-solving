/**
 * https://leetcode.com/problems/meeting-rooms-ii/
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
//first answer
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, (v1, v2) -> Integer.compare(v2.start, v1.start));

		List<Interval> rest = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			rest.add(intervals[i]);
		}
		int room = 0;
		while(!rest.isEmpty()) {
			room++;
			int size = rest.size();
			Interval current = rest.remove(size - 1);
			int lastEnd = current.end;
			for (int i = size - 2; i >= 0; i--) {
				Interval next = rest.get(i);
				if (next.start >= lastEnd) {
					rest.remove(i);
					lastEnd = next.end;
				}
			}
		}
		
		return room;
    }
}




//second answer(don't use the lambda);
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval v1, Interval v2) {
				return Integer.compare(v2.start, v1.start);
			}
		});

		List<Interval> rest = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			rest.add(intervals[i]);
		}
		int room = 0;
		while(!rest.isEmpty()) {
			room++;
			int size = rest.size();
			Interval current = rest.remove(size - 1);
			int lastEnd = current.end;
			for (int i = size - 2; i >= 0; i--) {
				Interval next = rest.get(i);
				if (next.start >= lastEnd) {
					rest.remove(i);
					lastEnd = next.end;
				}
			}
		}
		
		return room;
    }
}



//priority queue(solution)
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>(){
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});

		PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.end, i2.end);	
			}
		});
		
		queue.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval current = intervals[i];
			if (current.start >= queue.peek().end) {
				queue.remove();
			}
			queue.add(current);
		}
		return queue.size();
	}
}



//Chronological Ordering(solution)
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		Integer[] startTimes = new Integer[intervals.length];
		Integer[] endTimes = new Integer[intervals.length];
		for(int i = 0; i < intervals.length; i++) {
			startTimes[i] = intervals[i].start;
			endTimes[i] = intervals[i].end;
		}

		Arrays.sort(startTimes, new Comparator<Integer>(){
			@Override
			public int compare(Integer v1, Integer v2) {
				return Integer.compare(v1, v2);
			}
		});

		Arrays.sort(endTimes, new Comparator<Integer>(){
			@Override
			public int compare(Integer v1, Integer v2) {
				return Integer.compare(v1, v2);
			}
		});

		int startPointer = 1;
		int endPointer = 0;
		int room = 1;
		while(startPointer < intervals.length) {
			if (startTimes[startPointer] >= endTimes[endPointer]) {
				startPointer++;
				endPointer++;
			} else {
				room++;
				startPointer++;
			}
		}
		return room;
	}
}


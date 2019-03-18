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
//first solution
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




//second solution(don't use the lambda);
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

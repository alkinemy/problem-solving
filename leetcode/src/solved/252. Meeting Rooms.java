/**
 * https://leetcode.com/problems/meeting-rooms/
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
    public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return false;
		}
		Arrays.sort(intervals, (v1, v2) -> Integer.compare(v1.start, v2.start));        

		for (int i = 0; i < intervals.length - 1; i++) {
			Interval current = intervals[i];
			Interval next = intervals[i + 1];
			if (next.start < current.end) {
				return false;
			}
		}
		return true;
    }
}


//second answer(don't use the lambda)
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return true;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval v1, Interval v2) {
				return Integer.compare(v1.start, v2.start);
			}
		});
		int currentEnd = intervals[0].end;
		for (int i = 1; i < intervals.length; i++) {
			if (currentEnd > intervals[i].start) {
				return false;
			}
			currentEnd = intervals[i].end;
		}
		return true;
    }
}

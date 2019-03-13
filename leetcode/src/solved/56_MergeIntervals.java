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


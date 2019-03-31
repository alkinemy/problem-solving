/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */

//first answer(sort) - O(nlogn)
class Solution {
	public int[][] kClosest(int[][] points, int K) {
		if (points == null || points.length == 0 || K == points.length) {
			return points;
		}

		Arrays.sort(points, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				int d1 = p1[0] * p1[0] + p1[1] * p1[1];
				int d2 = p2[0] * p2[0] + p2[1] * p2[1];
				return Integer.compare(d1, d2);
			}
		});

		return Arrays.copyOf(points, K);
	}
}

//second answer(priority queue) O(nlogn)
class Solution {
	public int[][] kClosest(int[][] points, int K) {
		if (points == null || points.length == 0 || K == points.length) {
			return points;
		}

		PriorityQueue<int[]> queue = new PriorityQueue(new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				int d1 = p1[0] * p1[0] + p1[1] * p1[1];
				int d2 = p2[0] * p2[0] + p2[1] * p2[1];
				return Integer.compare(d1, d2);
			}
		});

		for (int i = 0; i < points; i++) {
			queue.add(points[i]);
		}

		int[][] result = new int[K][];
		for (int i = 0; i < K; i++) {
			result[i] = queue.remove();
		}
		return result;
	}
}

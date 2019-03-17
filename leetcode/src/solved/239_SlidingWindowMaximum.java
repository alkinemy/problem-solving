/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */

//first answer(max heap)
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0 || nums == null || nums.length == 0) {
			return new int[0];
		}

		int[] result = new int[nums.length - k + 1];
		Queue<Node> queue = new PriorityQueue<>((v1, v2) -> Integer.compare(v2.value, v1.value));
		for (int i = 0; i < nums.length; i++) {
			queue.add(new Node(nums[i], i));
			if (i < k - 1) {
				continue;
			}
			while(queue.peek().index < i - k + 1) {
				queue.poll();
			}
			result[i - k + 1] = queue.peek().value;
		}
		return result;
	}

	class Node {
		int value;
		int index;

		public Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}

//second answer
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (k == 0 || nums == null || nums.length == 0) {
			return new int[0];
		}

		int maxIndex = -1;
		int maxValue = Integer.MIN_VALUE;
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length - k + 1; i++) {
			if (maxIndex < i) {
				maxIndex = i;
				maxValue = nums[i];
				for(int j = i + 1; j < i + k; j++) {
					int current = nums[j];
					if (current >= maxValue) {
						maxIndex = j;
						maxValue = current;
					}
				}
				result[i] = maxValue;
			} else {
				int current = nums[i + k - 1];
				if (current >= maxValue) {
					maxIndex = i;
					maxValue = current;
				}
				result[i] = maxValue;
			}
		}
		return result;
	}
}



//use deque(solution)
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return new int[0];
		}

		Deque<Integer> deque = new ArrayDeque<>();
		int maxIndex = 0;
		for (int i = 0; i < k; i++) {
			removeUnavailable(deque, nums, i, k);
			deque.addLast(i);
			if (nums[maxIndex] < nums[i]) {
				maxIndex = i;
			}
		}
		int[] result = new int[nums.length - k + 1];
		result[0] = nums[maxIndex];

		for(int i = k; i < nums.length; i++) {
			removeUnavailable(deque, nums, i, k);
			deque.addLast(i);
			result[i - k + 1] = nums[deque.getFirst()];
		}
		return result;
	}

	private void removeUnavailable(Deque<Integer> deque, int[] nums, int index, int k) {
		if (!deque.isEmpty() && deque.getFirst() == index - k) { //범위를 넘어서는 인덱스 삭제
			deque.removeFirst();
		}
		while(!deque.isEmpty() && nums[deque.getLast()] < nums[index]) {
			deque.removeLast();
		}
	}
}





//use DP(solution)
class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k == 0) {
			return new int[0];
		}
		if (k == 1) {
			return nums;
		}

		int[] leftMax = new int[nums.length];
		int[] rightMax = new int[nums.length];
		for (int i = 0; i < nums.length / k; i++) {
			for (int j = 0; j < k; j++) {
				int leftCurrent = i * k + j;
				int rightCurrent = i * k + (k - j - 1);

				if (leftCurrent < nums.length) {
					if (j == 0) {
						leftMax[leftCurrent] = nums[leftCurrent];
					} else {
						leftMax[leftCurrent] = Math.max(leftMax[leftCurrent - 1], nums[leftCurrent]);
					}
				}
				if (rightCurrent < nums.length) {
					if (j == 0 || rightCurrent == nums.length - 1) {
						rightMax[rightCurrent] = nums[rightCurrent];
					} else {
						rightMax[rightCurrent] = Math.max(rightMax[rightCurrent + 1], nums[rightCurrent]);
					}
				}
			}
		}

		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length - k + 1; i++) {
			int start = i;
			int end = i + k - 1;
			result[i] = Math.max(rightMax[start], leftMax[end]);
		}
		return result;
	}
}













/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */

//first answer
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

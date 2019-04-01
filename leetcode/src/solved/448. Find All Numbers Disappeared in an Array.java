/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */


//time limit exceeded
class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Collections.emptyList();
		}

		int i = 0;
		while (i < nums.length) {
			int nextIndex = -1;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == 0) {
					continue;
				}
				if (nums[nums[j] - 1] != 0) {
					nextIndex = nums[j] - 1;
					break;
				}
			}
			if (nextIndex == -1) {
				break;
			}
			while(i < nums.length && nums[nextIndex] != 0) {
				int value = nums[nextIndex];
				nums[nextIndex] = 0;
				nextIndex = value - 1;
				i++;
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] != 0) {
				result.add(j + 1);
			}
		}
		return result;
	}
}

//time complexity: O(n), space complexity: O(n)
class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Collections.emptyList();
		}

		Map<Integer, Integer> pos = new HashMap<>();
		for (int i = 0;  i < nums.length; i++) {
			pos.put(nums[i], i);
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			if (!pos.containsKey(i)) {
				result.add(i);
			}
		}
		return result;
	}
}


//time complexity: O(n), space complexity: O(n)
//use array intead of hash map
class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Collections.emptyList();
		}

		int[] pos = new int[nums.length];
		for (int i = 0;  i < nums.length; i++) {
			pos[nums[i] - 1] = 1;
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			if (pos[i - 1] == 0) {
				result.add(i);
			}
		}
		return result;
	}
}


//time complexity: O(n), space complexity: O(1)?
class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Collections.emptyList();
		}

		int i = 0;
		while(i < nums.length) {
			if (nums[nums[i] - 1] != nums[i]) {
				swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] !=  j + 1) {
				result.add(j + 1);
			}
		}
		return result;
	}

	void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}




















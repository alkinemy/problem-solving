/**
 * https://leetcode.com/problems/permutations-ii/
 */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Collections.emptyList();
		}

		List<Integer> numList = new LinkedList<>();
		for (int num : nums) {
			numList.add(num);
		}

		Collections.sort(numList);
		return permute(numList);
    }

	List<List<Integer>> permute(List<Integer> nums) {
		if (nums.size() == 0) {
			List<List<Integer>> result = new ArrayList<>();
			result.add(new LinkedList<>());
			return result;
		}

		int first = nums.get(0);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			int current = nums.get(i);
			if (i == 0 || nums.get(i - 1) != current) {
				List<Integer> copy = new LinkedList<>(nums);
				copy.remove(i);
				List<List<Integer>> exceptCurrent = permute(copy);
				for (List<Integer> except : exceptCurrent) {
					except.add(0, current);
				}
				result.addAll(exceptCurrent);
			}
		}
		return result;
	}
}


//book solution
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Collections.emptyList();
		}
		
		Map<Integer, Integer> counts = new HashMap<>();
		for (int num : nums) {
			int count = counts.getOrDefault(num, 0) + 1;
			counts.put(num, count);
		}
		
		List<List<Integer>> result = new ArrayList<>();
		computePermutations(counts, nums.length, new ArrayList<>(), result);
		return result;
	}

	void computePermutations(Map<Integer, Integer> counts, int remaining, List<Integer> current, List<List<Integer>> result) {
		if (remaining == 0) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int num : counts.keySet()) {
			int count = counts.get(num);
			if (count > 0) {
				counts.put(num, count - 1);
				int currentLength = current.size();
				current.add(num);
				computePermutations(counts, remaining - 1, current, result);
				current.remove(currentLength);
				counts.put(num, count);
			}
		}
	}
}


//faster solution
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null || nums.length == 0) {
			return Collections.emptyList();
		}

		Arrays.sort(nums);
		boolean[] visited = new boolean[nums.length];
		List<List<Integer>> result = new ArrayList<>();
		getPermutations(nums, new ArrayList<>(), visited, result);
		return result;
	}

	void getPermutations(int[] nums, List<Integer> current, boolean[] visited, List<List<Integer>> result) {
		if (current.size() == nums.length) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (visited[i]) {
				continue;
			}
			if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
				continue;
			}

			visited[i] = true;
			int value = nums[i];
			current.add(value);
			getPermutations(nums, current, visited, result);
			current.remove(current.size() - 1);
			visited[i] = false;
		}
	}

}


























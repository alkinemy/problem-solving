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

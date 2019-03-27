/**
 * https://leetcode.com/problems/permutations/
 */


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

        return buildPermutations(nums, 0, new LinkedList<>());
    }

    List<List<Integer>> buildPermutations(int[] nums, int index, List<List<Integer>> permutations) {
        if (index == nums.length) {
            return permutations;
        }
        if (index == 0) {
            List<Integer> initial = new LinkedList<>();
            initial.add(nums[index]);
            permutations.add(initial);
            return buildPermutations(nums, index + 1, permutations);
        }

        int current = nums[index];
        List<List<Integer>> newPermutations = new ArrayList<>();
        for (List<Integer> list : permutations) {
            for (int i = 0; i < list.size() + 1; i++) {
                List<Integer> newPermutation = new LinkedList<>(list);
                newPermutation.add(i, current);
                newPermutations.add(newPermutation);
            }
        }
        return buildPermutations(nums, index + 1, newPermutations);
    }
}


//solution
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }

		List<Integer> numsList = new ArrayList<>();
		for (int num : nums) {
			numsList.add(num);
		}

		List<List<Integer>> result = new ArrayList<>();
		getPermutations(numsList, 0, result);
		return result;
	}

	void getPermutations(List<Integer> nums, int index, List<List<Integer>> result) {
		if (index == nums.size()) {
			result.add(new ArrayList<>(nums));
			return;
		}

		for (int i = index; i < nums.size(); i++) {
			Collections.swap(nums, i, index);
			getPermutations(nums, index + 1, result);
			Collections.swap(nums, i, index);
		}
	}
}


//book - 8.7 solution1
class Solution {
    public List<List<Integer>> permute(int[] nums) {
		if (nums  == null || nums.length == 0) {
			return Collections.emptyList();
		}

		List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
		return getPermutations(numsList);
	}

	List<List<Integer>> getPermutations(List<Integer> nums) {
		if (nums.size() == 0) {
			List<List<Integer>> result = new ArrayList<>();
			result.add(new LinkedList<Integer>());
			return result;
		}

		int current = nums.get(0);
		List<List<Integer>> permutations = new ArrayList<>();
		List<List<Integer>> restPermutations = getPermutations(nums.subList(1));
		for (List<Integer> restPermutation : restPermutations) {
			for (int i = 0; i <= restPermutation.size(); i++) {
				List<Integer> permutation = new LinkedList<>(restPermutation);
				permutation.add(i, current);
				permutations.add(permutation);
			}
		}
		return permutations;
	}
}


//book - 8.7 solution2
class Solution {
    public List<List<Integer>> permute(int[] nums) {
		if (nums  == null || nums.length == 0) {
			return Collections.emptyList();
		}

		List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
		return getPermutations(numsList);
	}

	List<List<Integer>> getPermutations(List<Integer> nums) {
		if (nums.size() == 0) {
			List<List<Integer>> result = new ArrayList<>();
			result.add(new LinkedList<>());
			return result;
		}

		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			int current = nums.get(i); 
			List<Integer> rest = new LinkedList<>(nums);
			rest.remove(i);
			List<List<Integer>> permutations = getPermutations(rest);
			for (List<Integer> permutation : permutations) {
				permutation.add(0, current);
				result.add(permutation);
			}
		}
		return result;
	}
}































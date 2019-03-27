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

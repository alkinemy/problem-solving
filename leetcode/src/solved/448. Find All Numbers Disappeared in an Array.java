/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */


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

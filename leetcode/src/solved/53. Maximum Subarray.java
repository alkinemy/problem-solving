/**
 * https://leetcode.com/problems/maximum-subarray/
 */

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (min < 0) {
                max = Math.max(max, sum - min);
            } else {
                max = Math.max(max, sum);
            }
            min = Math.min(min, sum);
        }
        return max;
    }
}

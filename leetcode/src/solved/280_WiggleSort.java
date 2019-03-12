/**
 * https://leetcode.com/problems/wiggle-sort/
 */

class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                swap(nums, 0, 1);
            }
            return;
        }

        for (int i = 1; i < nums.length; i += 2) {
            int highest = getHighest(nums, i - 1, i, i + 1);
            if (highest < nums.length) {
                swap(nums, highest, i);
            }
        }
    }

    public int getHighest(int[] nums, int i, int j, int k) {
        int iValue = i < nums.length ? nums[i] : Integer.MIN_VALUE;
        int jValue = j < nums.length ? nums[j] : Integer.MIN_VALUE;
        int kValue = k < nums.length ? nums[k] : Integer.MIN_VALUE;

        if (iValue >= jValue && iValue >= kValue) {
            return i;
        }
        if (jValue >= iValue && jValue >= kValue) {
            return j;
        }
        return k;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

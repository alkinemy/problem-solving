/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */

//first answer
class Solution {
    public int[] productExceptSelf(int[] nums) {
		if (nums.length == 0) {
			return new int[0];
		}
		int[] fromLeft = new int[nums.length];
		int[] fromRight = new int[nums.length];

		fromLeft[0] = nums[0];
		fromRight[nums.length - 1] = nums[nums.length - 1];
		for (int i = 1; i < nums.length; i++) {
			fromLeft[i] = fromLeft[i - 1] * nums[i];
			fromRight[nums.length - i - 1] = fromRight[nums.length - i] * nums[nums.length - i - 1];
		}
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int left = (i - 1) >= 0 ? fromLeft[i - 1] : 1;
			int right = (i + 1) < nums.length ? fromRight[i + 1] : 1;
			result[i] = left * right;
		}
		return result;
    }
}


//second answer(little bit fast)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] fromLeft = new int[nums.length];
        int[] fromRight = new int[nums.length];

        fromRight[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            fromRight[i] = fromRight[i + 1] * nums[i];
        }
        int left = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int right = (i + 1) < nums.length ? fromRight[i + 1] : 1;
            result[i] = left * right;
            left *= nums[i];
        }
        return result;
    }
}

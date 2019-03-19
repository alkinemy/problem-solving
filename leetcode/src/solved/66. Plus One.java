/**
 * https://leetcode.com/problems/plus-one/
 */

class Solution {
    public int[] plusOne(int[] digits) {
        boolean allNine = true;
        for (int d : digits) {
            if (d != 9) {
                allNine = false;
                break;
            }
        }
        if (allNine) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
            if (carry == 0) {
                break;
            }
        }
        return digits;
    }
}

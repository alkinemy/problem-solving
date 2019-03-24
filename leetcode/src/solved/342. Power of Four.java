/**
 * https://leetcode.com/problems/power-of-four/
 */

class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        for (int i = 0; i < 31; i += 2) {
            int mask = 1 << i;
            if ((num & ~mask) == 0) {
                return true;
            }
        }
        return false;
    }
}

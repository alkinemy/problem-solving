/**
 * https://leetcode.com/problems/power-of-two/
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        int i = 0;
        while (true) {
            int mask = 1 << i;
            if (mask > n) {
                return false;
            }
            if ((n & mask) != 0) {
                return (n & ~mask) == 0;
            }
            i++;
        }
    }
}

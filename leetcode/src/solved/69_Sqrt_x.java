/**
 * https://leetcode.com/problems/sqrtx/
 */

//first answer
class Solution {
    public int mySqrt(int x) {
        int i = 1;
        while(x / i >= i) {
            i++;
        }
        return i - 1;
    }
}

//second answer
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int end = 1;
        while(x / end >= end) {
            end *= 2;
        }
        if (x / end == end) {
            return end;
        }
        int start = end / 2;

        while(start < end) {
            if (end - start == 1) {
                return start;
            }
            int middle = (start + end) / 2;
            int value = x / middle;
            if (value == middle) {
                return middle;
            } else if (value > middle) {
                start = middle;
            } else {
                end = middle;
            }
        }
        return 0;
    }
}

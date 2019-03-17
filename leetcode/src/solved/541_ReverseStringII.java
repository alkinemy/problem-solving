/**
 * https://leetcode.com/problems/reverse-string-ii/
 */

class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return s;
        }

        char[] input = s.toCharArray();
        int start = 0;
        while(start < input.length) {
            reverse(input, start, start + k - 1);
            start += 2 * k;
        }
        return new String(input);
    }

    public void reverse(char[] array, int start, int idealEnd) {
        int end = Math.min(idealEnd, array.length - 1);
        while(start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */

class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int start = 0;
        char[] result = s.toCharArray();
        for (int end = 0; end < result.length; end++) {
            if (result[end] == ' ') {
                reverse(result, start, end - 1);
                start = end + 1;
            }
        }
        reverse(result, start, result.length - 1);
        return new String(result);
    }

    public void reverse(char[] input, int start, int end) {
        while(start < end) {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }
}

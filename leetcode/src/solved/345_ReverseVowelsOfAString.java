/**
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 */

class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        int start = 0;
        int end = s.length() - 1;
        char[] result = s.toCharArray();
        while(start < end) {
            if (vowels.contains(result[start])) {
                while(start < end && !vowels.contains(result[end])) {
                    end--;
                }
                if (start < end) {
                    swap(result, start, end);
                    end--;
                }
            }
            start++;
        }
        return new String(result);
    }

    void swap(char[] input, int i, int j) {
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}

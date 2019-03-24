/**
 * https://leetcode.com/problems/decode-string/
 */

class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<StringBuilder> builders = new Stack<>();
        Stack<Integer> repeats = new Stack<>();
        StringBuilder builder = new StringBuilder();
		int repeat = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') { //number
				repeat = repeat * 10 + (c - '0');
            } else if (c == '[') {
                builders.push(builder);
				repeats.push(repeat);
                builder = new StringBuilder();
				repeat = 0;
            } else if (c == ']') {
                StringBuilder previous = builders.pop();
                repeat = repeats.pop();
                for(int j = 0; j < repeat; j++) {
                    previous.append(builder);
                }
                builder = previous;
				repeat = 0;
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

//first accepted answer
class Solution {
    public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> seen = new HashMap<>();
		int start = 0;
		int end = 0;
		int maxLength = -1;
		while(end < s.length()) {
			char c = s.charAt(end);
			if (seen.containsKey(c) && seen.get(c) >= start) {
				int currentLength = end - start;
				if (maxLength < currentLength) {
					maxLength = currentLength;
				}
				start = seen.get(c) + 1;
			} 
			seen.put(c, end);
			end++;
		}

		
        int finalLength = end - start ;
        if (finalLength > maxLength) {
            maxLength = finalLength;
        }   
        return maxLength;
    }
}


//second accepted answer
class Solution {
    public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> seen = new HashMap<>();
		int start = 0;
		int end = 0;
		int maxLength = 0;
		while(end < s.length()) {
			char c = s.charAt(end);
			if (seen.containsKey(c) && seen.get(c) >= start) {
				start = seen.get(c) + 1;
			}
			int currentLength = end - start + 1;
			if (maxLength < currentLength) {
				maxLength = currentLength;
			}
			seen.put(c, end);
			end++;
		}
        return maxLength;
    }
}

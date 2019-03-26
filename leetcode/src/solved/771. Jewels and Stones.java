/**
 * https://leetcode.com/problems/jewels-and-stones/
 */

class Solution {
    public int numJewelsInStones(String J, String S) {
		if (J == null || S == null || J.length() == 0 || S.length() == 0) {
			return 0;
		}

		Map<Character, Integer> counter = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			int count = counter.getOrDefault(c, 0) + 1;
			counter.put(c, count);
		}

		int result = 0;
		for (int i = 0; i < J.length(); i++) {
			result += counter.getOrDefault(J.charAt(i), 0);
		}
		return result;
    }
}

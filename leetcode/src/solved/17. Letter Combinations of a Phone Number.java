/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

//first solution
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        Map<Character, char[]> assigned = new HashMap<>();
        assigned.put('2', new char[] {'a', 'b', 'c'});
        assigned.put('3', new char[] {'d', 'e', 'f'});
        assigned.put('4', new char[] {'g', 'h', 'i'});
        assigned.put('5', new char[] {'j', 'k', 'l'});
        assigned.put('6', new char[] {'m', 'n', 'o'});
        assigned.put('7', new char[] {'p', 'q', 'r', 's'});
        assigned.put('8', new char[] {'t', 'u', 'v'});
        assigned.put('9', new char[] {'w', 'x', 'y', 'z'});

        int rows = 1;
        for (char c : digits.toCharArray()) {
            rows *= assigned.get(c).length;
        }
        int columns = digits.length();
        char[][] result = new char[rows][columns];
        int repeat = 1;
        for (int c = digits.length() - 1; c >= 0; c--) {
            char current = digits.charAt(c);
            char[] available = assigned.get(current);
            for (int r = 0; r < rows; r++) {
                int index = ((r / repeat) % available.length);
                result[r][c] = available[index];
            }
            repeat *= available.length;
        }

        List<String> strs = new ArrayList<>();
        for (char[] array : result) {
            strs.add(new String(array));
        }
        return strs;
    }
}




//backtracking(solution)
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        Map<Character, char[]> mappings = new HashMap<>();
        mappings.put('2', new char[] {'a', 'b', 'c'});
        mappings.put('3', new char[] {'d', 'e', 'f'});
        mappings.put('4', new char[] {'g', 'h', 'i'});
        mappings.put('5', new char[] {'j', 'k', 'l'});
        mappings.put('6', new char[] {'m', 'n', 'o'});
        mappings.put('7', new char[] {'p', 'q', 'r', 's'});
        mappings.put('8', new char[] {'t', 'u', 'v'});
        mappings.put('9', new char[] {'w', 'x', 'y', 'z'});

		List<String> result = new ArrayList<>();
		backtrack(digits, mappings, "", result);
		return result;
	}

	void backtrack(String digits, Map<Character, char[]> mappings, String combined, List<String> result) {
		if (digits.length() == 0) {
			result.add(combined);
			return;
		}

		char[] mapping = mappings.get(digits.charAt(0));
		String nextDigits = digits.substring(1, digits.length());
		for (char c : mapping) {
			backtrack(nextDigits, mappings, combined + c, result);
		}
	}
}

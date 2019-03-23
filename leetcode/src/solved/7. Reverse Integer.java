/**
 * https://leetcode.com/problems/reverse-integer/
 */

//first answer
class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        while(x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        long result = 0;
        long pos = (int)Math.pow(10, list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i) * pos;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            pos /= 10;
        }
        return (int)result;

    }
}

//second answer(faster than first answer)
class Solution {
    public int reverse(int x) {
        if (x < 10 && x > -10) {
			return x;
        }

		long result = 0;
		while (x != 0) {
			result = result * 10 + (x % 10);
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				return 0;
			}
			x /= 10;
		}
		return result;
	}
}

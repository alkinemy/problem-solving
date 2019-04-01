/**
 * https://leetcode.com/problems/valid-perfect-square/
 */

class Solution {
	public boolean isPerfectSquare(int num) {
		if (num == 0) {
			return false;
		}

		return check(num, 1, num);
	}

	boolean check(int num, long min, long max) {
		if (max < min) {
			return false;
		}
		long guess = (max + min) / 2;
		long guessSquare = guess * guess;
		if (guessSquare == num) {
			return true;
		} else if (guessSquare < num) {
			return check(num, guess + 1, max);
		} else {
			return check(num, min, guess - 1);
		}
	}
}

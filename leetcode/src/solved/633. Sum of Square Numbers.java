/**
 * https://leetcode.com/problems/sum-of-square-numbers/
 */

//first answer
class Solution {
	public boolean judgeSquareSum(int c) {
		if (c == 0) {
			return true;
		}
		int start = 0;
		int end = (int)Math.sqrt(c);
		while (start <= end) {
			long squareSum = (long)start * start + (long)end * end;
			if (squareSum == c) {
				return true;
			} else if (squareSum > c) {
				end--;
			} else {
				start++;
			}
		}
		return false;
	}

}

//solution(sqrt)
class Solution {
	public boolean judgeSquareSum(int c) {
		for (long a = 0; a * a < c; a++) {
			double b = Math.sqrt(c - a * a);
			if (b == (int)b) {
				return true;
			}
		}
		return false;
	}
}


/**
 * https://leetcode.com/problems/powx-n/
 */

class Solution {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1.d;
		}

		long m = n;
		if (m < 0) {
			m = -m;
			x = 1/x;
		}

		m = m / 2;
		double half = myPow(x, (int)m);
		if (n % 2 == 0) {
			return half * half;
		} else {
			return half * half * x;
		}
	}

}

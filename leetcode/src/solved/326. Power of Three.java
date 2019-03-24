/**
 * https://leetcode.com/problems/power-of-three/
 */

//first answer
class Solution {
    public boolean isPowerOfThree(int n) {
		if (n < 10) {
			return n == 1 || n == 3 || n == 9;
		}

		if (n % 3 != 0) {
			return false;
		}
		int sum = 0;
		int mod = n;
		while(mod != 0) {
			sum += mod % 10;
			mod /= 10;
		}
		if (sum % 9 == 0) {
			return isPowerOfThree(n / 3);
		} 
		return false;
    }
}

//second answer
class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }
}

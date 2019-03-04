
/*
 * https://practice.geeksforgeeks.org/problems/modular-exponentiation-for-large-numbers/0#ExpectOP
 */

//pow(a, b) % c;
int modular(int a, int b, int c) {
	if (b == 0) {
		return 1;
	}
	return (a * modular(a, b - 1, c)) % c;
}


int multiply(int a, int b) {
	int bigger = a > b ? a : b;
	int smaller = a < b ? a : b;
	return innerMultiply(smaller, bigger);
}

int innerMultiply(int smaller, int bigger) {
	if (smaller == 0) {
		return 0;
	}
	if (smaller == 1) {
		return bigger;
	}
	int divided = smaller >> 1;
	int s1 = innerMultiply(divided, bigger);
	int s2 = s1;
	if (smaller % 2 == 1) {
		s2 += bigger;
	}
	return s1 + s2;
}

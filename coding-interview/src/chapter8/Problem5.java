
int multiply(int a, int b) {
	if (b == 0) {
		return 0;
	}
	if (b == 1) {
		return a;
	}
	int exponent = 0;
	int exponential = 1;
	while (exponential < b) {
		exponential = 1 << ++exponent;
	}
	int result = a << (exponent - 1);
	int rest = b - (exponential >> 1);
	if (rest == 0) {
		return result;
	}
	return result + multiply(a, rest);
}

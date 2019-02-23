
int countTurning(int v1, int v2) {
	int xor = v1 ^ v2;
	int count = 0;
	while (xor != 0) {
		if ((xor & 1) == 1) {
			count++;
		}
		xor /= 2;
	}
	return count;
}

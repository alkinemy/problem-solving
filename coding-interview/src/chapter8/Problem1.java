int countWays(int n) {
	int[] ways = new int[n];
	ways[0] = 1;
	ways[1] = 2;
	ways[2] = 4;

	for (int i = 3; i < n; i++) {
		ways[i] = ways[i - 1] + ways[i - 2] + ways[i - 3];
	}
	return ways[n - 1];
}

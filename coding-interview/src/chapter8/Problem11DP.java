int countMethod(int n) {
	int[] coins = { 25, 10, 5, 1 };
	int[][] cache = new int[n + 1][coins.length];
	return countMethod(n, coins, 0, cache);
}

int countMethod(int n, int[] coins, int coinIndex, int[][] cache) {
	if (cache[n][coinIndex] > 0) {
		return cache[n][coinIndex];
	}
	if (coinIndex >= coins.length - 1) {
		return 1;
	}

	int count = 0;
	for (int i = 0; i <= (n / coins[coinIndex]); i++) {
		int changes = n - (i * coins[coinIndex]);
		count += countMethod(changes, coins, coinIndex + 1, cache);
	}

	cache[n][coinIndex] = count;
	return count;
}

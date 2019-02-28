int countMethod(int n) {
	int[] coins = { 25, 10, 5, 1 };
	return countMethod(n, coins, 0);
}

int countMethod(int n, int[] coins, int coinIndex) {
	if (coinIndex >= coins.length - 1) {
		return 1;
	}
	int count = 0;
	for (int i = 0; i <= (n / coins[coinIndex]); i++) {
		int changes = n - (i * coins[coinIndex]);
		count += countMethod(changes, coins, coinIndex + 1);
	}
	return count;
}

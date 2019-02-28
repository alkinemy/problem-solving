int countMethod(int n) {
	int count = 0;
	for (int i = 0; i <= (n / 25); i++) {
		int minusQuarter = n - (i * 25);
		int dimeMax = minusQuarter / 10;
		for (int j = 0; j <= dimeMax; j++) {
			int minusDime = minusQuarter - (j * 10);
			int nickelMax = minusDime / 5;
			for (int k = 0; k <= nickelMax; k++) {
				count++;
			}
		}
	}
	return count;
}

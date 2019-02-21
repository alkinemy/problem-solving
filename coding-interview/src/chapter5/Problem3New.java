
int findLongest(int value) {
	int currentCount = 0;
	int previousCount = 0;
	int maxLength = 0;
	while(value != null) {
		int rest = value % 2;
		if (rest == 1) {
			currentCount++;
		} else {
			int foreRest = (value / 2) % 2;
			if (foreRest == 1) {
				previousCount = currentCount;
				currentCount = 0;
			} else {
				previousCount = 0;
				currentCount = 0;
			}
		}
		if (maxLength < (previousCount + currentCount + 1)) {
			maxLength = previousCount + currentCount +1;
		}

		value = value / 2;
	}
	return maxLength;
}

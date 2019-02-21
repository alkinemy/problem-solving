
int findLongestPositiveBitCount(int number) {
	boolean shown = false;
	int maxCount = 0;
	int current = number;
	int currentCount = 0;
	while (current != 0) {
		int rest = current % 2;
		if (rest == 1) {
			currentCount++;
		} else if (!shown && currentCount != 0) {
			shown = true;
			currentCount++;
		} else {
			if (maxCount < currentCount) {
				maxCount = currentCount;
			}
			currentCount = 0;
			shown = false;
		}
		current = current / 2;
	}

	if (maxCount < currentCount) {
		maxCount = currentCount;
	}

	if (!shown) {
		maxCount++;
	}

	return maxCount;
}

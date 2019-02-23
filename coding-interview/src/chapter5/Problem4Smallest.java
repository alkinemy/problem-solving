
int getPrevious(int value) {
	int negativeCount = 0;
	int positiveCount = 0;

	int pointer = 0;
	int current = value;
	while (current != 0) {
		if ((current & 1) == 1) {
			positiveCount++;
			pointer++;
			current /= 2;
		} else {
			break;
		}
	}

	while (current != 0) {
		if ((current & 1) == 0) {
			negativeCount++;
			pointer++;
			current /= 2;
		} else {
			break;
		}
	}

	int result = value;
	int unsetMask = ~(1 << pointer);
	result &= unsetMask;

	int unsetAllMask = ~((1 << pointer) - 1);
	result &= unsetAllMask;

	int setMask = ((1 << positiveCount + 1) - 1) << (negativeCount - 1);
	result |= setMask;
	return result;
}

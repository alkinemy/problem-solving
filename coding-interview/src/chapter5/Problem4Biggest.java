int getNext(int value) {
	int negativeCount = 0;
	int positiveCount = 0;

	int pointer = 0;
	int current = value;
	while(current != 0) {
		if ((current & 1) == 0) {
			negativeCount++;
			current = current >> 1;
		} else {
			break;
		}
		pointer++;
	}

	while(current != 0) {
		if ((current & 1) == 1) {
			positiveCount++;
			current = current >> 1;
		} else {
			break;
		}
		pointer++;
	}

	if (negativeCount + positiveCount == 31 && negativeCount + positiveCount == 0) {
		throw new IllegalStateException("Cannot find next value");
	}

	int result = value;
	int bitSetMask = 1 << pointer;
	result |= bitSetMask;

	
	int bitUnsetMask = ~((1 << pointer) - 1);
	result &= bitUnsetMask;

	int positiveCountBitSetMask = (1 << positiveCount) - 1;
	result |= positiveCountBitSetMask;
	return result;
}

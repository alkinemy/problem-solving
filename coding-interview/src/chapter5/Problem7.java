
int exchangeOddEven(int value) {
	//홀수 mask를 만든다
	int count = countBits(value);
	int oddMask = makeOddMask(count); // 101010
	int evenMask = ~oddMask; // 010101
	
	int odd = value & oddMask;
	odd = odd >> 1;

	int even = value & evenMask;
	even = even << 1;

	return odd | even;
}

int countBits(int value) {
	int count = 0;
	while (value != 0) {
		value = value >> 1;
		count++;
	}
	return count;
}

//101010
int makeOddMask(int count) {
	int mask = 0;
	while(count > 0) {
		if (count % 2 == 1) {
			count--;
			continue;
		}
		mask |= (1 << (count - 1));
		count--;
	}
	return mask;
}

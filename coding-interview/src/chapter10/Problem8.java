

void printDuplicated(int[] array, int n) {
	byte[] bitVector = new byte[n + 1];
	
	for (int i = 0; i < array.length; i++) {
		int value = array[i];
		int index = value / 8;
		int mask = 1 << (value % 8);
		if ((bitVector[index] & mask) > 0) {
			System.out.println(value);
		} else {
			bitVector[index] |= mask;
		}
	}
}

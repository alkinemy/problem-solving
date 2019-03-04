

int printDoNotShown(String fileName) {
	int rangeSize = 1 << 20;

	int[] numberBlocks = countByRange(fileName, rangeSize);
	int block = findMissingBlock(numberBlocks);
	if (block == -1) {
		return;
	}
	return getDoNotShown(fileName, block);
}

int[] countByRange(String fileName, int rangeSize) {
	int arraySize = 
	Scanner scanner = new Sacnner(new FileReader(fileName));
}



void generateInteger(String fileName) {
	long vectorSize = ((long)Integer.MAX_VALUE) + 1;
	byte[] bitVector = new byte[(int)(vectorSize / 8)];

	Scanner scanner = new Scanner(new FileReader(fileName));
	while(scanner.hasNextInt()) {
		int value = scanner.nextInt();
		bitVector[value / 8] |= (1 << (value % 8));
	}

	for (int i = 0; i < bitVector.length; i++) {
		byte currentByte = bitVector[i];
		for (int j = 0; j < 8; j++) {
			if ((currentByte & (1 << j)) == 0) {
				System.out.println((i * 8) + j);
			}
		}
	}

	scanner.close();
}

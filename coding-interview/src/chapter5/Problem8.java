drawLine(byte[] screen, int width, int x1, int x2, int y) {
	int startIndex = (x1 / 8) * y;
	int startBit = x1 % 8;
	int endIndex = (x2 / 8) * y;
	int endBit = x2 % 8;

	for (int i = x1 % 8; i < 8; i++) {
		byte b = screen[startindex];
		int mask = 1 << i;
		if (b & mask > 0) {
			System.out.print("1");
		} else {
			System.out.print("0");
		}
	}

	for (int i = startIndex + 1; i < endIndex; i++) {
		byte b = screen[i];
		for (int j = 0; j < 8; j++) {
			int mask = 1 << j;
			if (b & mask > 0) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
		}
	}

	for (int i = 0; i < endBit; i++) {
		byte b = screen[endIndex];
		if (b & mask > 0) {
			System.out.print("1");
		} else {
			System.out.print("0");
		}
	}
}


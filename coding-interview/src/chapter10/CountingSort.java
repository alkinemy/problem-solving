int[] countingSort(int[] array) {
	int max = 0;
	for (int i = 0; i < array.length; i++) {
		if (max < array[i]) {
			max = array[i];
		}
	}

	int[] counts = new int[max];
	for (int i = 0; i < array.length; i++) {
		counts[array[i] - 1]++;
	}
	for (int i = 1; i < counts.length; i++) {
		counts[i] += counts[i - 1];
	}

	int[] result = new int[array.length];
	for (int i = array.length - 1; i >= 0; i--) {
		int value = array[i];
		result[counts[value - 1] - 1] = value;
		counts[value - 1]--;
	}
	return result;
}

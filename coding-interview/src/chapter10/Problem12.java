

int[] sort(int[] array) { //use more spaces
	Arrays.sort(array);
	int pivot = array.length / 2;
	
	int[] result = new int[array.length];
	for (int i = 0; i < array.length; i += 2) {
		int delta = i / 2;
		result[i] = array[pivot + delta];
		if (i + 1 < array.length) {
			result[i + 1] = array[delta];
		}
	}
	return result;
}

void sort2(int[] array) { //O(nlogn) -> sorting time
	Arrays.sort(array);
	for (int i = 1; i < array.length; i += 2) {
		int temp = array[i];
		array[i] = array[i - 1];
		array[i - 1] = temp;
	}
}

void sort3(int[] array) {
	for (int i = 1; i < array.length; i += 2) {
		int biggest = getBiggestIndex(array, i - 1, i, i + 1);
		if (biggest != i) {
			swap(array, i, biggest);
		}
	}
}

int getBiggestIndex(int[] array, int start, int middle, int end) {
	int startValue = array[start];
	int middleValue = array[middle];
	int endValue = end < array.length ? array[end] : Integer.MIN_VALUE;

	if (startValue > middleValue && startValue > endValue) {
		return start;
	}
	if (middleValue > startValue && middleValue > endValue) {
		return middle;
	}
	return end;
}

void swap(int[] array, int ai, int bi) {
	int temp = array[ai];
	array[ai] = array[bi];
	array[bi] = temp;
}

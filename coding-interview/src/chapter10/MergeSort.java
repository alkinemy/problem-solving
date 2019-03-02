

void mergeSort(int[] array, int[] helper, int start, int end) {
	if (start >= end) {
		return;
	}
	
	int middle = (start + end) / 2;
	mergeSort(array, helper, start, middle);
	mergeSort(array, helper, middle + 1, end);
	merge(array, helper, start, middle, end);
}

void merge(int[] array, int[] helper, int start, int middle, int end) {
	for (int i = start; i <= end; i++) {
		helper[i] = array[i];
	}

	int leftCursor = start;
	int rightCursor = middle + 1;

	int current = start;
	while(leftCursor <= middle && rightCursor <= end) {
		if (helper[leftCursor] <= helper[rightCursor]) {
			array[current] = helper[leftCursor];
			leftCursor++;
		} else {
			array[current] = helper[rightCursor];
			rightCursor++;
		}
		current++;
	}

	int remaining = middle - leftCursor;
	for (int i = 0; i <= remaining; i++) {
		array[current + i] = hepler[leftCursor + i];
	}
}


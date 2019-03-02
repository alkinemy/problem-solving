void quickSort(int[] array, int start, int end) {
	int pivot = partition(array, start, end);
	if (start < pivot - 1) {
		quickSort(array, start, pivot - 1);
	}
	if (pivot < end) {
		quickSort(array, pivot, end);
	}
}

int partition(int[] array, int start, int end) {
	int pivotValue = array[(start + end) / 2];
	int leftCursor = start;
	int rightCursor = end;
	while (leftCursor <= rightCursor) {
		while(array[leftCursor] < pivotValue) {
			leftCursor++;
		}
		while(array[rightCursor] > pivotValue) {
			rightCursor--;
		}
		if (leftCursor <= rightCursor) {
			int temp = array[leftCursor];
			array[leftCursor] = array[rightCursor];
			array[rightCursor] = temp;
			leftCursor++;
			rightCursor--;
		}
	}
	return leftCursor;
}

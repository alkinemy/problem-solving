
int binarySearch(int[] array, int target) {
	int start = 0;
	int end = array.length - 1;

	while(start <= end) {
		int middle = (start + end) / 2;
		if (target < array[middle]) {
			end = middle - 1;
		} else if (target > array[middle]) {
			start = middle + 1;
		} else {
			return middle;
		}
	}
	return -1;
}

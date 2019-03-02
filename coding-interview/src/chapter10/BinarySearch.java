
int findIndex(int[] array, int target) {
	return findIndex(array, 0, array.length, target);
}

int findIndex(int[] array, int start, int end, int target) {
	if (start >= end) {
		return -1;
	}
	int middle = (start + end) / 2;
	if (target == array[middle]) {
		return middle;
	}
	if (target < array[middle]) {
		return findIndex(array, start, middle, target);
	}
	return findIndex(array, middle + 1, end, target);
}

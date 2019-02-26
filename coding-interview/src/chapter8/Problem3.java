
int findIndex(int[] a) {
	return findIndex(a, 0, a.length - 1);
}

int findIndex(int[] a, int start, int end) {
	if (start > end) {
		return -1;
	}

	int middle = (start + end) / 2;
	if (a[middle] < middle) { //upper
		return findIndex(a, middle + 1, end);
	} else if (a[midele] > middle) { //lower
		return findIndex(a, start, middle - 1);
	} else {
		return middle;
	}
}

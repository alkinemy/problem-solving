
int findIndex(int[] a) {
	return findIndex(a, 0, a.length - 1);
}

int findIndex(int[] a, int start, int end) {
	if (start > end) {
		return -1;
	}

	int middle = (start + end) / 2;
	if (a[middle] == middle) {
		return middle;
	}
	int leftEnd = Math.min(middle - 1, a[middle]);
	int leftFoundIndex = findIndex(a, start, leftEnd);
	if (leftFoundIndex != -1) {
		return leftFoundIndex;
	}
	int rightStart = Math.max(middle + 1, a[middle]);
	int rightFoundIndex = findIndex(a, rightStart, end);
	if (rightFoundIndex != -1) {
		return rightFoundIndex;
	}
	return -1;
}

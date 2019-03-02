
int findIndex(Listy listy, int x) {
	if (listy.elementAt(0) == x) {
		return 0;
	}
	int bound = findBoundary(listy, x);
	return binarySearch(listy, x, bound / 2, bound);
}

int findBoundary(Listy listy, int x) {
	int i = 1;
	while (!(listy.elementAt(i) == -1 || listy.elementAt(i) >= x)) {
		i *= 2;
	}
	return i;
}

int binarySearch(Listy listy, int x, int start, int end) {
	if (start > end) {
		return -1;
	}

	int middle = (start + end) / 2;
	int middleValue = listy.elementAt(middle);
	if (middleValue == x) {
		return middle
	}
	if (middleValue < x) {
		return binarySearch(listy, x, middle + 1, end);
	}
	if (x < middleValue || middleValue == -1) {
		return binarySearch(listy, x, start, middle - 1);
	}
	return -1;
}

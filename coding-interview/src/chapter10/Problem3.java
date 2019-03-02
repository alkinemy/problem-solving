
int findIndex(int[] a, int x, int start, int end) {
	if (start > end) {
		return -1;
	}

	int startValue = a[start];
	int middleIndex = (start + end) / 2;
	int middleValue = a[middleIndex];
	int endValue = a[end];

	if (x == startValue) {
		return start;
	}
	if (x == middleValue) {
		return middleIndex;
	}
	if (x == endValue) {
		return end;
	}

	if (startValue < middleValue) { //컷이 오른쪽
		if (x < startValue || x > middleValue) { //right
			return findIndex(a, x, middleIndex + 1, end);
		}
		return findIndex(a, x, start, middleIndex - 1);
	} else if (startValue > middleValue) { //컷이 왼쪽
		if (x < startValue && x > middleValue) {
			return findIndex(a, x, middleIndex + 1, end);
		}
		return findIndex(a, x, start, middleIndex - 1);
	} else {
		if (middleValue != endValue) {
			return findIndex(a, x, middleIndex + 1, end);
		}
		int leftSearch = findIndex(a, x, start, middleIndex - 1);
		if (leftSearch != -1) {
			return leftSearch;
		}
		return findIndex(a, x, middleIndex + 1, end);
	}
}

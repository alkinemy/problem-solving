
int findIndex(String[] array, String x, int start, int end) {
	if (start > end) {
		return -1;
	}
	int middle = (start + end) / 2;
	String middleValue = array[middle];

	if ("".equals(middleValue)) {
		int left = middle - 1;
		int right = middle + 1;
		while(!(left < start && right > end)) {
			if (left >= start && !"".equals(array[left])) {
				middle = left;
				middleValue = array[left];
				break;
			}
			if (right <= end && !"".equals(array[right])) {
				middle = right;
				middleValue = array[right];
				break;
			}
			left--;
			right++;
		}
		if (left < start && right > end) {
			return -1;
		}
	}

	if (x.equals(middleValue)) {
		return middle;
	}
	if (x.compareTo(middleValue) > 0) {
		return findIndex(array, x, middle + 1, end);
	}
	return findIndex(array, x, start, middle - 1);
}

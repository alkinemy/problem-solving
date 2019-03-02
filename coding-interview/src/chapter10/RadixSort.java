void radixSort(int[] array, int k) { //k 자리수
	int[] helper = new int[array.length];
	for (int i = 0; i < k; i++) {
		countingSort(array, i, helper);
	}
}

void countingSort(int[] array, int k, int[] helper) {
	int[] counts = new int[10];
	for (int i = 0; i < array.length; i++) {
		int number = getIth(array[i], k);
		counts[number]++;
	}

	for (int i = 1; i < counts.length; i++) {
		counts[i] += counts[i - 1];
	}

	for (int i = array.length - 1; i >= 0; i--) {
		int number = getIth(array[i], k);
		helper[counts[number] - 1] = array[i];
		counts[number]--;
	}

	for (int i = 0; i < helper.length; i++) {
		array[i] = helper[i];
	}
}

int getIth(int number, int i) {
	int lowerBase = (int)Math.pow(10, i);
	int upperBase = (int)Math.pow(10, i + 1);
	return (number % upperBase) / lowerBase;
}

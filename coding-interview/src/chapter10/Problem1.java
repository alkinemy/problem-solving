

void merge(int[] a, int [] b) {
	int aCursor = a.length - 1;
	int bCursor = b.length - 1;

	int current = (a.length + b.length) - 1;
	while (!(aCursor == -1 || bCursor == -1)) {
		if (a[aCursor] > b[bCursor]) {
			a[current] = a[aCursor--];
		} else {
			a[current] = b[bCursor--];
		}
		current--;
	}
	for (int i = bCursor; i >= 0; i--) {
		a[i] = b[i];
	}
}

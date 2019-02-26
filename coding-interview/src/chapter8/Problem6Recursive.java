void move(int n, int from, int to) {
	System.out.println(n + ": " + from + " -> " + to);
}

void hanoi(int n, int from, int by, int to) {
	if (n == 1) {
		move(n, from, to);
		return;
	}
	hanoi(n - 1, from, to, by);
	move(n, from, to);
	hanoi(n - 1, by, from, to);
}

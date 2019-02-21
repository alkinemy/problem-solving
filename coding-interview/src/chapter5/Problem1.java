
int insert(int n, int m, int i, int j) {
	int foreUnsetMask = -1 << (j + 1);
	int backUnsetMask = (1 << i) - 1;
	int unsetMask = foreUnsetMask | backUnsetMask;

	int setMask = m << i;
	
	return  (n & unsetMask) | setMask;
}

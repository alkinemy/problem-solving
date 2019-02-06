//문자열 회전


//O(n^2)
boolean isRotatedSentence(String original, String rotated) {
	if (original == null || rotated == null) {
		return false;
	}
	if (original.length() != rotated.length()) {
		return false;
	}
	char startOfRotated = rotated.charAt(0);
	
	boolean isDifferent = false;
	for (int i = 0; i < original.length(); i++) {
		char c = original.charAt(i);
		if (c == startOfRotated) {
			for (int j = 0; j < original.length() - i; j++) {
				if (original.charAt(j + i) != rotated.charAt(j)) {
					isDifferent = true;
					break;
				}
			}
			if (isDifferent) {
				isDifferent = false;
				continue;
			} else {
				if (isSubstring(rotated, original.substring(0, i))) {
					return true;
				}
				return false;
			}
		}
	}
	return false;
}

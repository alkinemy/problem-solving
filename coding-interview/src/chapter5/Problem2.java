
String printBinary(double value) {
	if (value >= 1 || value < 0) {
		return "ERROR";
	}

	StringBuilder result = new StringBuilder();
	result.append("0.")
	int counter = 2;
	double pivot = 0.5;
	double currentValue = value;
	while(currentValue != 0) {
		if (counter > 32) {
			return "ERROR";
		}
		if (currentValue >= pivot) {
			currentValue -= pivot;
			result.append("1");
		} else {
			result.append("0");
		}
		pivot /= 2;
		counter++;
	}
	
	return result.toString();
	
}

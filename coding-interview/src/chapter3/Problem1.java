
class ThreeStack {
	private final Integer[] array = new Integer[128];

	int firstStackIndex = -3;
	int secondStackIndex = -2;
	int thirdStackIndex = -1;

	public void firstStackPush(int value) {
		firstStackIndex += 3;
		array[firstStackIndex] = value;
	}
	
	public int firstStackPop() {
		if (firstStackIndex < 0) {
			throw new EmptyStackException();
		}

		int result = array[firstStackIndex];
		array[firstStackIndex] = null; //null
		firstStackIndex -= 3;
		return result;
	}

}

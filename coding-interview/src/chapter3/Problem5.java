


void sort(Stack<Integer> stack) {
	Stack<Integer> reversedResult = sort(stack, new Stack<>(), stack.size());
	while(!reversedResult.isEmpty()) {
		stack.push(reversedResult.pop());
	}
}

Stack<Integer> sort(Stack<Integer> target, Stack<Integer> result, int size) {
	if (size == 0) {
		return result;
	}

	Integer min = null;
	int count = size;
	while(count-- > 0) {
		Integer targetValue = target.pop();
		if (min == null) {
			min = targetValue;
			continue;
		}
		if (targetValue < min) {
			result.push(min)
			min = targetValue;
		} else {
			result.push(targetValue);
		}
	}
	count = size - 1;
	while(count-- > 0) {
		target.push(result.pop());
	}
	return sort(target, result, --size);
}

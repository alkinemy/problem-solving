//1. 기준이 되는 노드를 찾아서(같은 값이거나 큰 수중 가장 가까운 값)
//2. 리스트를 다시 돌면서 작은 값은 앞에 끼워넣고 큰 값은 뒤에 끼워넣고
//


Node division(Node head, int value) {

	int difference = Integer.MAX_VALUE;
	Node pivot = null;
	Node current = head;

	int pivotIndex = 0;
	int currentIndex = 0;
	while(current != null) {
		currentIndex++;
		if (current.data == value) {
			pivot = current;
			pivotIndex = currentIndex;
			break;
		}
		if (current.data > value) {
			if (difference > current.data - value) {
				pivot = current;
				pivotIndex = currentIndex;
				difference = current.data - value;
			}
		}
		current = current.next;
	}

	if (pivot == head || pivot == null) {
		return head;
	}

	current = head;
	currentIndex = 0;
	while(current != null) {
		currentIndex++;
		if (current == pivot) {
			current = current.next;
			continue;
		}

		if (current.value > pivot.data && currentIndex < pivotIndex) {
			int temp = pivot.data;
			pivot.data = current.value;
			current.value = temp;
			pivotIndex = currentIndex;

			pivot = current;
			current = current.next;
			continue;
		}
		if (current.value < pivot.data && currentIndex > pivotIndex) {
			int valueTemp = pivot.data;
			pivot.data = current.value;
			current.value = valueTemp;
			
			int pivotTemp = currentIndex;
			currentIndex = pivotIndex;
			pivotIndex = pivotTemp;

			Node pivotNodeTemp = current;
			current = pivot.next;
			pivot = pivotNodeTemp;
			continue;
		}
		
		current = current.next;
	}
	return head;
}


//time complexity: O(n)
//space complexity: O(n)
boolean isPalindrome(CharNode head) {
	if (head == null) {
		return false;
	}

	CharNode reversed = getReversed(head);
	CharNode originalCurrent = head;
	CharNode reversedCurrent = reversed;

	while(originalCurrent != null) {
		if (originalCurrent.data != reversedCurrent.data) {
			return false;
		}
		originalCurrent = originalCurrent.next;
		reversedCurrent = reversedCurrent.next;
	}
	return true;
}

CharNode getReversed(CharNode head) {
	CharNode reversed = new CharNode(head.data);
	
	CharNode reversedNext = reversed;
	CharNode current = head.next;
	while(current != null) {
		CharNode previousAppend = new CharNode(current.data);
		previousAppend.next = reversedNext;
		reversedNext = previousAppend;
		current = current.next;
	}
	return reversedNext;
}

//O(n^2)
boolean isPalindrome2(CharNode head) {
	if (head == null) {
		return false;
	}

	CharNode last = head;
	while (last.next != null) {
		last = last.next;
	}

	if (last == head) {
		return true;
	}
	return checkPalindrome(head, last);
}

boolean checkPalindrome(CharNode head, CharNode last) {
	if (head == last) {
		return true;
	}

	if (head.data == last.data) {
		if (head.next == last) {
			return true;
		}
		CharNode lastPrevious = head;
		while (lastPrevious.next != last) {
			lastPrevious = lastPrevious.next;
		}
		CharNode nextHead = head.next;
		return checkPalindrome(nextHead, lastPrevious);
	}
	return false;
}



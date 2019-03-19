/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		if (lists.length == 1) {
			return lists[0];
		}

		int size = lists.length / 2;
		if (lists.length % 2 == 1) {
			size += 1;
		}
		ListNode[] newLists = new ListNode[size];
		for (int i = 0; i < lists.length / 2; i++) {
			ListNode node1 = lists[2 * i];
			ListNode node2 = lists[2 * i + 1];
            ListNode head = null;
			ListNode current = null;
			while (node1 != null || node2 != null) {
				if (node1 == null) {
					if (current == null) {
						current = node2;
                        head = current;
					} else {
						current.next = node2;
					}
					break;
				}
				if (node2 == null){
					if (current == null) {
						current = node1;
                        head = current;
					} else {
						current.next = node1;
					}
					break;
				}
				if (node1.val < node2.val) {
					if (current == null) {
						current = node1;
						node1 = node1.next;
                        head = current;
					} else {
						current.next = node1;
						current = current.next;
						node1 = node1.next;
					}
				} else {
					if (current == null) {
						current = node2;
						node2 = node2.next;
                        head = current;
					} else {
						current.next = node2;
						current = current.next;
						node2 = node2.next;
					}
				}
			}
			newLists[i] = head;
		}
        if (lists.length % 2 == 1) {
            newLists[size - 1] = lists[lists.length - 1];
        }
		return mergeKLists(newLists);
    }
}


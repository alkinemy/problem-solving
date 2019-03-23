/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode head = null;
		ListNode current = null;
		if (l1.val <= l2.val) {
			head = l1;
			l1 = l1.next;
			current = head;
		} else {
			head = l2;
			l2 = l2.next;
			current = head;
		}
		while(l1 != null || l2 != null) {
			if (l1 == null) {
				current.next = l2;
				current = current.next;
				break;
			} else if (l2 == null) {
				current.next = l1;
				current = current.next;
				break;
			}
			if (l1.val <= l2.val) {
				current.next = l1;
				current = current.next;
				l1 = l1.next;
			} else {
				current.next = l2;
				current = current.next;
				l2 = l2.next;
			}
		}
		return head;
    }
}

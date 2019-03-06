/**
 * https://leetcode.com/problems/add-two-numbers/
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = null;
		ListNode current = head;
		while (l1 != null && l2 != null) {
			int added = l1.val + l2.val + carry;
			carry = added / 10;
			if (head == null) {
				head = new ListNode(added % 10);
				current = head;
			} else {
				current.next = new ListNode(added % 10);
				current = current.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		ListNode rest = null;
		if (l1 != null) {
			rest = l1;
		} else if (l2 != null) {
			rest = l2;
		}
		while (rest != null) {
			int added = rest.val + carry;
			carry = added / 10;
			current.next = new ListNode(added % 10);
			current = current.next;
			rest = rest.next;
		}
		if (carry == 1) {
			current.next = new ListNode(carry);
		}
		return head;
    }
}

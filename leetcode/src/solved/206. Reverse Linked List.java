/**
 * https://leetcode.com/problems/reverse-linked-list/
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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode previous = head;
        ListNode current = head.next;
        while(current != null) {
            ListNode next = current.next;
            if (previous == head) {
                previous.next = null;
            }
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}

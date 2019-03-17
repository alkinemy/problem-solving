/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */

//first answer
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = counter.getOrDefault(s.charAt(i), 0) + 1;
            counter.put(s.charAt(i), count);
        }
        for (int i = 0; i < s.length(); i++) {
            if (counter.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}


//second answer (remove second loop)
class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        Map<Character, Node> nodes = new HashMap<>();
        Node head = new Node(null, null, 0);
        Node tail = head;
        nodes.put(s.charAt(0), head);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (nodes.containsKey(c)) {
                Node current = nodes.get(c);
                Node previous = current.previous;
                Node next = current.next;
                if (previous != null) {
                    previous.next = current.next;
                }
                if (next != null) {
                    next.previous = current.previous;
                }
                current.previous = null;
                current.next = null;
                if (head == current) {
                    head = next;
                }
                if (tail == current) {
                    tail = previous;
                }
            } else {
                if (head == null && tail == null) {
                    head = new Node(null, null, i);
                    tail = head;
                } else {
                    tail.next = new Node(tail, null, i);
                    tail = tail.next;
                }
                nodes.put(c, tail);
            }
        }
        if (head == null) {
            return -1;
        }
        return head.index;
    }

    class Node {
        Node previous;
        Node next;
        int index;

        Node(Node previous, Node next, int index) {
            this.previous = previous;
            this.next = next;
            this.index = index;
        }
    }
}

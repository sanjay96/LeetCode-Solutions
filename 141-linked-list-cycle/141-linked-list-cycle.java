/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode first = null, second = null;
        first = head;
        second = first.next;
        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
            if (second == first)
                return true;
        }
        return false;
    }
}

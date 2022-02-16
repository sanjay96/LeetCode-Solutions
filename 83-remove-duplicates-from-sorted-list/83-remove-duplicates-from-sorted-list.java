/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode slow = head, fast = null;
        fast = slow.next;
        
        while (fast != null) {
            if (slow.val == fast.val) {
                fast = fast.next;
            }
            else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = fast;
        return newHead.next;
        
    }
}
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
    public void reorderList(ListNode head) {
        // Find the middle
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode temp = null;
        
        // Reverse the 2nd half of the list
        while (second != null) {
            temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        
        second = prev;
        ListNode first = head, temp1 = null, temp2 = null;
        
        // Merge the first and second half of the list
        while (second != null && first != null) {
            temp1 = first.next;
            temp2 = second.next;
            first.next = second;
            second.next = temp1;
            second = temp2;
            first = temp1;
        }
    }
}
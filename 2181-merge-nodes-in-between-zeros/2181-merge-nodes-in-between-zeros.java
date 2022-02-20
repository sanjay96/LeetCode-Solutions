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
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        ListNode fast = head;
        fast = fast.next;
        int sum = 0;
        
        while (fast != null) {
            if (fast.val != 0) {
                sum = sum + fast.val;
            }
            else {
                temp.next = new ListNode(sum);
                temp = temp.next;
                sum = 0;
            }
            fast = fast.next;
        }
        return newHead.next;
    }
}

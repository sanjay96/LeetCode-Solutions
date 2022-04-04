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
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int temp1 = list.get(k-1);
        int temp2 = list.get(list.size() - k);
        list.set(k-1, temp2);
        list.set(list.size() - k, temp1);
        ListNode newHead = new ListNode(0);
        ListNode newTemp = newHead;
        for (int x : list) {
            newTemp.next = new ListNode(x);
            newTemp = newTemp.next;
        }
        newTemp.next = null;
        return newHead.next;
    }
}
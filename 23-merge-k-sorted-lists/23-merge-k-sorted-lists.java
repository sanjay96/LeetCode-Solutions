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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (list1 != null  && list2 != null) {
            int x = list1 != null ? list1.val : 0;
            int y = list2 != null ? list2.val : 0;
            if (x > y) {
                temp.next = new ListNode(y);
                list2 = list2.next;
            }
            else {
                temp.next = new ListNode(x);
                list1 = list1.next;
            }
            temp = temp.next;
        }
        while (list1 != null) {
            temp.next = new ListNode(list1.val);
            list1 = list1.next;
            temp = temp.next;
        }
        while (list2 != null) {
            temp.next = new ListNode(list2.val);
            list2 = list2.next;
            temp = temp.next;
        }
        return newHead.next;
    } 
}
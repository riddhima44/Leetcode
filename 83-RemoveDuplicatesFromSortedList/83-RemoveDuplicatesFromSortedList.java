// Last updated: 1/19/2026, 10:49:48 PM
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode curr = head;
        
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // skip duplicate
            } else {
                curr = curr.next;           // move forward
            }
        }

        return head;
    }
}

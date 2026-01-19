// Last updated: 1/19/2026, 10:50:27 PM
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // Edge case: no lists
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Step 1: push head of each non-empty list
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Dummy node to build result
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Step 2: extract min and push next
        while (!pq.isEmpty()) {
            ListNode curr = pq.poll();
            tail.next = curr;
            tail = tail.next;

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return dummy.next;
    }
}

// Last updated: 4/26/2026, 2:44:08 PM
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        // Dummy node to handle edge case (deleting head)
14        ListNode dummy = new ListNode(0);
15        dummy.next = head;
16        
17        ListNode fast = dummy;
18        ListNode slow = dummy;
19        
20        // Move fast n+1 steps ahead
21        for (int i = 0; i <= n; i++) {
22            fast = fast.next;
23        }
24        
25        // Move both pointers
26        while (fast != null) {
27            fast = fast.next;
28            slow = slow.next;
29        }
30        
31        // Delete the node
32        slow.next = slow.next.next;
33        
34        return dummy.next;
35    }
36}
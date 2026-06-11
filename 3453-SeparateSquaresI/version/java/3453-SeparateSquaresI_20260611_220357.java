// Last updated: 6/11/2026, 10:03:57 PM
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
12    public ListNode rotateRight(ListNode head, int k) {
13
14        if (head == null || head.next == null || k == 0)
15            return head;
16
17        int n = 1;
18        ListNode tail = head;
19
20        while (tail.next != null) {
21            tail = tail.next;
22            n++;
23        }
24
25        k %= n;
26
27        if (k == 0)
28            return head;
29
30        // Make circular
31        tail.next = head;
32
33        int steps = n - k;
34        ListNode newTail = head;
35
36        for (int i = 1; i < steps; i++) {
37            newTail = newTail.next;
38        }
39
40        ListNode newHead = newTail.next;
41
42        newTail.next = null;
43
44        return newHead;
45    }
46}
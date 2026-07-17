// Last updated: 7/17/2026, 11:54:10 PM
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
12    public int pairSum(ListNode head) {
13
14        ListNode slow = head;
15        ListNode fast = head;
16
17        // Find middle
18        while (fast != null && fast.next != null) {
19            slow = slow.next;
20            fast = fast.next.next;
21        }
22
23        // Reverse second half
24        ListNode prev = null;
25        while (slow != null) {
26            ListNode next = slow.next;
27            slow.next = prev;
28            prev = slow;
29            slow = next;
30        }
31
32        // Compare twin sums
33        int ans = 0;
34        ListNode first = head;
35        ListNode second = prev;
36
37        while (second != null) {
38            ans = Math.max(ans, first.val + second.val);
39            first = first.next;
40            second = second.next;
41        }
42
43        return ans;
44    }
45}
// Last updated: 1/21/2026, 9:57:16 PM
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
12    public ListNode modifiedList(int[] nums, ListNode head) {
13        Set<Integer> set = new HashSet<>();
14        for (int x : nums) {
15            set.add(x);
16        }
17
18        ListNode dummy = new ListNode(0);
19        dummy.next = head;
20
21        ListNode prev = dummy;
22        ListNode curr = head;
23
24        while (curr != null) {
25            if (set.contains(curr.val)) {
26                prev.next = curr.next; // delete
27            } else {
28                prev = curr;           // keep
29            }
30            curr = curr.next;
31        }
32
33        return dummy.next;
34    }
35}
36